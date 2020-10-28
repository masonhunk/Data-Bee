/**
 * Copyright (C) 2018 WeBank, Inc. All Rights Reserved.
 */
package com.webank.blockchain.data.bee.parser.generated.bo.method;

import com.webank.blockchain.data.bee.common.bo.data.MethodBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=true)
public class ComplexSolConstructorBO extends MethodBO {
	private long i;
	private String s;
}
