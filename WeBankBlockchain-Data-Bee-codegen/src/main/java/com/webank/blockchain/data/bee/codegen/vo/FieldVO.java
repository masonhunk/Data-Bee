/**
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webank.blockchain.data.bee.codegen.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * FieldVO
 *
 * @Description: FieldVO
 * @author maojiayu
 * @data Dec 28, 2018 4:13:40 PM
 *
 */
@Data
@Accessors(chain = true)
public class FieldVO {
    private String sqlName;
    private String solidityName;
    private String javaName;
    private String sqlType;
    private String solidityType;
    private String javaType;
    private String entityType;
    private String typeMethod; // 转化方法
    private String javaCapName;
    private int length;
}
