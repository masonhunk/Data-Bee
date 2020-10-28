package com.webank.blockchain.data.bee.db.service;

import com.webank.blockchain.data.bee.common.bo.data.BlockInfoBO;
import com.webank.blockchain.data.bee.common.bo.data.ContractInfoBO;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/26
 */

public interface DataStoreService {

    void storeBlockInfoBO(BlockInfoBO blockInfo);

    void storeContractInfo(ContractInfoBO contractInfoBO);
}
