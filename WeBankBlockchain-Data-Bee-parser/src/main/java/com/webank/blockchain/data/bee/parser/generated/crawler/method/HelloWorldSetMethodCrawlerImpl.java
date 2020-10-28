/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.parser.generated.crawler.method;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.sdk.abi.ABICodec;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.client.protocol.model.JsonTransactionResponse;
import org.fisco.bcos.sdk.model.TransactionReceipt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.webank.blockchain.data.bee.parser.crawler.face.BcosMethodCrawlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import com.webank.blockchain.data.bee.common.tools.AddressUtils;
import com.webank.blockchain.data.bee.common.tools.BigIntegerUtils;
import com.webank.blockchain.data.bee.common.tools.BoolUtils;
import com.webank.blockchain.data.bee.common.tools.BytesUtils;
import com.webank.blockchain.data.bee.common.tools.JacksonUtils;
import com.webank.blockchain.data.bee.common.tools.MethodUtils;
import lombok.extern.slf4j.Slf4j;
import com.webank.blockchain.wecredit.contracts.HelloWorld;
import com.webank.blockchain.data.bee.common.bo.data.MethodBO;
import com.webank.blockchain.data.bee.parser.generated.bo.method.HelloWorldSetBO;

@Slf4j
@Service
@ConditionalOnProperty(name = "monitor.HelloWorld.setMethodCrawlerService", havingValue = "on")
public class HelloWorldSetMethodCrawlerImpl implements BcosMethodCrawlerInterface {

	@Autowired
	private Client client;
    private HelloWorld contract;

	@Override
	public MethodBO transactionHandler(JsonTransactionResponse transaction, TransactionReceipt receipt, Date blockTimeStamp,
	  String methodName) {
		log.debug("Begin process HelloWorldSet Transaction");
		HelloWorldSetBO entity = new HelloWorldSetBO();
		entity.setTxHash(transaction.getHash());
		entity.setBlockHeight(transaction.getBlockNumber().longValue());
		ABICodec abiCodec = new ABICodec(client.getCryptoSuite());		
		entity.setBlockTimeStamp(blockTimeStamp);	
		entity.setIdentifier("HelloWorldSet");	
		if (StringUtils.equals(methodName, "constructor")) {
            entity.setContractAddress(receipt.getContractAddress());
        } else {
            entity.setContractAddress(receipt.getTo());
        }
				
		try {			
			List<Object> params =
                    MethodUtils.decodeMethodInput(contract.ABI, methodName, receipt, client);
		    if (!CollectionUtils.isEmpty(params)) {		
				entity.setN(String.valueOf(params.get(0)));
		}
			if (receipt.getOutput().length() > 2) {		
            	List<Object> outputList = abiCodec.decodeMethod(contract.ABI, methodName, receipt.getOutput());
       			if (!CollectionUtils.isEmpty(outputList) && receipt.getStatus().equals("0x0")) {
				}  
        	}
        				
		} catch (Exception e) {
            log.warn("Method {} parse error: ", methodName, e);
        }
		log.debug("end process HelloWorldSet Transaction");
		return entity;
	}
}
