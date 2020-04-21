package com.ly.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {
    @Value("${redis.nodes}")
    private String nodes;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = getNodes();
        return new JedisCluster(nodes);
    }

    private Set<HostAndPort> getNodes() {
        Set<HostAndPort> set = new HashSet<>();
        String[] nodesArray = nodes.split(",");	//获取node数组
        for (String node : nodesArray) {
            String host = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            set.add(new HostAndPort(host, port));
        }
        return set;
    }



//    @Value("${redis.host}")
//    private String host;
//    @Value("${redis.port}")
//    private Integer port;
//    @Value("${redis.password}")
//    private String password;
//    /**
//     * 配置哨兵
//     */
//    @Value("${redis.masterName}")
//    private String masterName;

//    @Bean("jedisSentinelPool")
//    public JedisSentinelPool jedisSentinelPool() {
//        Set<String> sentinels = new HashSet<>();
//        sentinels.add(nodes);
//        return new JedisSentinelPool(masterName, sentinels);
//    }
//
//    @Bean
//    public Jedis jedis(@Qualifier("jedisSentinelPool") JedisSentinelPool jedisSentinelPool) {
//
//        return jedisSentinelPool.getResource();
//    }

/*
    @Bean
    public Jedis jedis() {
       Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
        return jedis;
    }
*/

}
