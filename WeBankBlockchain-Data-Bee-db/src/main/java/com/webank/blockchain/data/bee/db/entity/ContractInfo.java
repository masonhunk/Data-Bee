package com.webank.blockchain.data.bee.db.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Entity(name = "contract_info")
@Table(name = "contract_info")
@ToString(callSuper = true)
public class ContractInfo extends IdEntity {

    @Column(name = "abi_hash", unique = true)
    protected String abiHash;

    @Lob
    @Column(name = "contract_abi")
    private String contractABI;

    @Lob
    @Column(name = "contract_binary")
    private String contractBinary;

    @Column(name = "version")
    private short version = 1;

    @Column(name = "contract_name")
    private String contractName;

    /** @Fields updatetime : depot update time */
    @UpdateTimestamp
    @Column(name = "depot_updatetime")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date depotUpdatetime;
}
