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
public class ComplexSolLogSetBytesBO extends EventBO {
    
	private String o;
	private String b;
}
