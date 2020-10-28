/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.parser.generated.bo.event;

import com.webank.blockchain.data.bee.common.bo.data.EventBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=true)
public class ComplexSolLogSetValuesBO extends EventBO {
    
	private Long i;
	private String a;
	private String s;
}
