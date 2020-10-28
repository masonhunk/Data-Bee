package com.webank.blockchain.data.bee.db.dao;

import cn.hutool.core.bean.BeanUtil;
import com.webank.blockchain.data.bee.common.bo.data.ContractInfoBO;
import com.webank.blockchain.data.bee.db.entity.ContractInfo;
import com.webank.blockchain.data.bee.db.repository.ContractInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/26
 */
@Component
public class ContractInfoDAO implements SaveInterface<ContractInfoBO>{

    @Autowired
    private ContractInfoRepository contractInfoRepository;

    public void save(ContractInfo contractInfo) {
        BaseDAO.saveWithTimeLog(contractInfoRepository, contractInfo);
    }

    @Override
    public void save(ContractInfoBO contractInfoBO) {
        ContractInfo contractInfo = contractInfoRepository.findByAbiHash(contractInfoBO.getAbiHash());
        if(contractInfo != null){
            return;
        }
        contractInfo = new ContractInfo();
        BeanUtil.copyProperties(contractInfoBO, contractInfo, true);
        save(contractInfo);
    }

}
