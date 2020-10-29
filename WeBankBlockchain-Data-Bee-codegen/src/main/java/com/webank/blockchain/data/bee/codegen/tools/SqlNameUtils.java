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
package com.webank.blockchain.data.bee.codegen.tools;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.blockchain.data.bee.codegen.config.SystemEnvironmentConfig;
import com.webank.blockchain.data.bee.codegen.enums.NameStyleEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * SqlNameUtils
 *
 * @Description: SqlNameUtils
 * @author maojiayu
 * @data Oct 12, 2019 11:16:54 AM
 *
 */
@Slf4j
@Service
public class SqlNameUtils {
    @Autowired
    private SystemEnvironmentConfig systemEnvironmentConfig;

    public String getSqlName(String contractName, String subName) {

        String sqlName =
                StringStyleUtils.upper2underline(contractName) + "_" + StringStyleUtils.upper2underline(subName);
        if (systemEnvironmentConfig.getNameStyle().equalsIgnoreCase(NameStyleEnum.RAW_CASE.getStyle())) {
            sqlName = contractName + subName;
        }
        // mysql最大支持64位，超过64位进行截取
        if (systemEnvironmentConfig.getDbIdentifierSplit().equalsIgnoreCase("true") && sqlName.length() > 55) {
            log.info("Cut sqlName {}", sqlName);
            sqlName = StringUtils.substring(sqlName, 0, 54);
        }
        return sqlName;
    }

}
