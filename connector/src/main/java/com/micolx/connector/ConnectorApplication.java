package com.micolx.connector;

import com.micolx.connector.utility.SessionManager;
import com.micolx.connector.zookeeper.ZKRegister;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.UnknownHostException;

@SpringBootApplication
public class ConnectorApplication {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer redis_port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisPool jedisProvider() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(2 * 1000);
        return new JedisPool(config, host, redis_port, 2 * 1000,
                password != null && !password.isEmpty() ? password : null);
    }


    public static void main(String[] args) throws UnknownHostException, InterruptedException, KeeperException {
        SpringApplication.run(ConnectorApplication.class, args);
        ZKRegister zkRegister = SpringContext.getBean(ZKRegister.class);
        zkRegister.register();
    }

}
