package com.micolx.registration_login.server_picker;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("zookeeper")
@Data
public class ZKConfiguration {
    private String host;
    private Integer port;
}
