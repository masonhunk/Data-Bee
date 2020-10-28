/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.parser.generated.crawler.event;

import java.math.BigInteger;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.codec.decode.TransactionDecoderInterface;
import org.fisco.bcos.sdk.transaction.codec.decode.TransactionDecoderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.webank.blockchain.wecredit.contracts.ComplexSol;
import com.webank.blockchain.wecredit.contracts.ComplexSol.LogSetSArrayEventResponse;
import com.webank.blockchain.data.bee.parser.crawler.face.BcosEventCrawlerInterface;
import com.webank.blockchain.data.bee.parser.generated.bo.event.ComplexSolLogSetSArrayBO;
import com.webank.blockchain.data.bee.common.bo.data.EventBO;
import com.webank.blockchain.data.bee.common.constants.ContractConstants;
import com.webank.blockchain.data.bee.common.tools.AddressUtils;
import com.webank.blockchain.data.bee.common.tools.BigIntegerUtils;
import com.webank.blockchain.data.bee.common.tools.BytesUtils;
import com.webank.blockchain.data.bee.common.tools.JacksonUtils;
import com.webank.blockchain.data.bee.parser.crawler.face.BcosEventCrawlerInterface;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "monitor.ComplexSol.LogSetSArrayCrawlerService", havingValue = "on")
public class ComplexSolLogSetSArrayCrawlerImpl implements BcosEventCrawlerInterface {
	@Autowired
    private Client client;
    @Autowired
    private CryptoKeyPair credentials;
    private ComplexSol contract;
    
    @Bean
    @ConditionalOnMissingBean
    public ComplexSol getComplexSol() {
        return ComplexSol.load(ContractConstants.EMPTY_ADDRESS, client, credentials); 

    }
	
	@Override
	public List<EventBO> handleReceipt(TransactionReceipt receipt, Date blockTimeStamp) {
		TransactionDecoderInterface decoder = new TransactionDecoderService(client.getCryptoSuite());
		List<EventBO> list = new ArrayList<>();
        try {
            	Map<String, List<Object>> map = decoder.decodeEvents(contract.ABI, receipt.getLogs());
           		List<Object> events = map.get(contract.LOGSETSARRAY_EVENT.getName());
           		
                if (!CollectionUtils.isEmpty(events)) {             
                        ComplexSolLogSetSArrayBO complexSolLogSetSArray = new ComplexSolLogSetSArrayBO();                
                        complexSolLogSetSArray.setIdentifier("ComplexSolLogSetSArray");		
						complexSolLogSetSArray.setBlockHeight(receipt.getBlockNumber());
						complexSolLogSetSArray.setEventContractAddress(receipt.getContractAddress());
						complexSolLogSetSArray.setTxHash(receipt.getTransactionHash());				
						
							complexSolLogSetSArray.setO(String.valueOf(events.get(0)));
							complexSolLogSetSArray.setN(String.valueOf(events.get(1)));
							complexSolLogSetSArray.setBlockTimeStamp(blockTimeStamp);
							log.debug("depot LogSetSArray:{}", complexSolLogSetSArray.toString());
							list.add(complexSolLogSetSArray);						
                }
        } catch (Exception e) {
            log.warn("Event parse error: {}", e);
        }		
		return list;
	}
}
