package com.webank.blockchain.data.bee.codegen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author wesleywang
 * @Description:
 * @date 2020/10/22
 */
@Configuration
@ConfigurationProperties("es")
@Data
public class ESBeanConfig {
    private String enabled = "false";
    private String clusterName;
    private String ip;
    private int port;

   
}
