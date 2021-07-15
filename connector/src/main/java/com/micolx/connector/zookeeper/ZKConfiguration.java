package com.micolx.connector.zookeeper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("zookeeper")
@Data
public class ZKConfiguration {
    private String host;
    private String port;
}
