package com.micolx.registration_login.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisPool jedisProvider() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(2 * 1000);
        return new JedisPool(config, host, port, 2 * 1000,
                password != null && !password.isEmpty() ? password : null);
    }
}
