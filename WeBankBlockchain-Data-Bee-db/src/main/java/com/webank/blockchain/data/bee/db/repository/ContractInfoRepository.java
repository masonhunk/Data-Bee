package com.webank.blockchain.data.bee.db.repository;

import com.webank.blockchain.data.bee.db.entity.ContractInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/26
 */
@Repository
public interface ContractInfoRepository extends JpaRepository<ContractInfo, Long>, JpaSpecificationExecutor<ContractInfo> {

    ContractInfo findByAbiHash(String abiHash);

}
