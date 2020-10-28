package com.webank.blockchain.data.bee.db.repository;

import com.webank.blockchain.data.bee.db.entity.TxRawData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/23
 */
@Repository
public interface TxRawDataRepository extends JpaRepository<TxRawData, Long>, JpaSpecificationExecutor<TxRawData> {

}
