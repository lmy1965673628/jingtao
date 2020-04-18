package com.ly.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.Jedis;

@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.password}")
    private String password;

    @Bean
    public Jedis jedis() {
        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
        return jedis;
    }
}
