/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.db.generated.repository.method;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.webank.blockchain.data.bee.db.generated.entity.method.ComplexSolSetBytes;
import com.webank.blockchain.data.bee.db.repository.RollbackInterface;


@Repository
public interface ComplexSolSetBytesMethodRepository extends JpaRepository<ComplexSolSetBytes, Long>, JpaSpecificationExecutor<ComplexSolSetBytes>, RollbackInterface {
	ComplexSolSetBytes findByTxHash(String txHash);
	
	@Transactional
    @Modifying
    @Query(value = "delete from  #{#entityName} where block_height >= ?1", nativeQuery = true)
    public void rollback(long blockHeight);
    
    @Transactional
    @Modifying
    @Query(value = "delete from  #{#entityName} where block_height >= ?1 and block_height< ?2", nativeQuery = true)
    public void rollback(long startBlockHeight, long endBlockHeight);
}

