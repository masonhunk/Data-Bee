package com.webank.blockchain.data.bee.db.service;

import com.webank.blockchain.data.bee.db.dao.BlockCommonDAO;
import com.webank.blockchain.data.bee.db.dao.BlockDetailInfoDAO;
import com.webank.blockchain.data.bee.db.dao.BlockRawDataDAO;
import com.webank.blockchain.data.bee.db.dao.BlockTxDetailInfoDAO;
import com.webank.blockchain.data.bee.db.dao.ContractInfoDAO;
import com.webank.blockchain.data.bee.db.dao.DeployedAccountInfoDAO;
import com.webank.blockchain.data.bee.db.dao.TxRawDataDAO;
import com.webank.blockchain.data.bee.db.dao.TxReceiptRawDataDAO;
import com.webank.blockchain.data.bee.common.bo.data.BlockInfoBO;
import com.webank.blockchain.data.bee.common.bo.data.CommonBO;
import com.webank.blockchain.data.bee.common.bo.data.ContractInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/26
 */
@Component
public class MysqlStoreService implements DataStoreService{

    @Autowired
    private BlockDetailInfoDAO blockDetailInfoDao;
    @Autowired
    private BlockTxDetailInfoDAO blockTxDetailInfoDao;
    @Autowired
    private BlockCommonDAO blockEventDao;
    @Autowired
    private BlockRawDataDAO blockRawDataDao;
    @Autowired
    private TxRawDataDAO txRawDataDao;
    @Autowired
    private TxReceiptRawDataDAO txReceiptRawDataDao;
    @Autowired
    private DeployedAccountInfoDAO deployedAccountInfoDao;
    @Autowired
    private ContractInfoDAO contractInfoDAO;

    @Override
    public void storeBlockInfoBO(BlockInfoBO blockInfo) {
        blockDetailInfoDao.save(blockInfo.getBlockDetailInfo());
        blockRawDataDao.save(blockInfo.getBlockRawDataBO());
        txRawDataDao.save(blockInfo.getTxRawDataBOList());
        deployedAccountInfoDao.save(blockInfo.getDeployedAccountInfoBOS());
        txReceiptRawDataDao.save(blockInfo.getTxReceiptRawDataBOList());
        blockTxDetailInfoDao.save(blockInfo.getBlockTxDetailInfoList());
        blockEventDao.save(blockInfo.getEventInfoList().stream().map(e -> (CommonBO) e).collect(Collectors.toList()),
                "event");
        blockEventDao.save(blockInfo.getMethodInfoList().stream().map(e -> (CommonBO) e).collect(Collectors.toList()),
                "method");
    }

    @Override
    public void storeContractInfo(ContractInfoBO contractInfoBO) {
        contractInfoDAO.save(contractInfoBO);
    }
}
