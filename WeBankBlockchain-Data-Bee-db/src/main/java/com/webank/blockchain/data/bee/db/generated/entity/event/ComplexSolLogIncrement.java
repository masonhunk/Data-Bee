/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.db.generated.entity.event;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.UpdateTimestamp;

import com.webank.blockchain.data.bee.db.entity.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
@Entity(name = "complex_sol_log_increment_event")
@Table(name = "complex_sol_log_increment_event", indexes = { @Index(name = "block_height", columnList = "block_height"),
        @Index(name = "block_timestamp", columnList = "block_timestamp"),
        @Index(name = "tx_hash", columnList = "tx_hash")})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ComplexSolLogIncrement extends IdEntity {
	@Column(name = "block_height")
    private long blockHeight;
    @Column(name = "tx_hash")
	private String txHash;
	@Column(name = "event_contract_address")
    private String eventContractAddress;
	@Column(name = "_sender_")
	private String sender;
	@Column(name = "_a_")
	private Long a;
	@Column(name = "block_timestamp")
	private Date blockTimeStamp;	
	@UpdateTimestamp
    @Column(name = "depot_updatetime")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date depotUpdatetime;
}
