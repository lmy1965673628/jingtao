package com.ly.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestRedis {
    @Autowired
    private Jedis jedis;

    /**
     * 测试String类型操作
     * 服务器前提：1.防火墙关闭  2.IP绑定注释  3.保护模式关闭
     */
    @Test
    public void test01() {
        //new Jedis() 第一个参数是服务器ip，第二个是端口号
        Jedis jedis = new Jedis("192.168.180.160", 6379);
        jedis.set("name", "olderSheep");
        System.out.println(jedis.get("name"));
    }

    /**
     * 操作Hash
     */
    @Test
    public void testHash() {
        Jedis jedis = new Jedis("192.168.180.160", 6379);
        jedis.hset("person", "id", "100");
        jedis.hset("person", "name", "人");
        jedis.hset("person", "age", "18");
        System.out.println(jedis.hgetAll("person"));
    }

    @Test
    public void testList() {
        Jedis jedis = new Jedis("192.168.180.160", 6379);
        jedis.lpush("list", "1", "2", "3", "4");
        System.out.println(jedis.rpop("list"));
    }

    @Test
    public void testLink() {
        jedis.set("test", "11111111111111");
        System.out.println(jedis.get("test"));

    }

    /**
     * redis分片测试
     */
    @Test
    public void testShards() {
        String host = "192.168.180.160";
        List<JedisShardInfo> shards =
                new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo(host, 6379));
        shards.add(new JedisShardInfo(host, 6380));
        shards.add(new JedisShardInfo(host, 6381));
        ShardedJedis jedis = new ShardedJedis(shards);
        jedis.set("0419", "分片操作");
        System.out.println(jedis.get("0419"));
    }

    /**
     * 测试哨兵
     */
    @Test
    public void testSentinel() {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.180.160:26379");
        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = pool.getResource();
        jedis.set("0420", "测试哨兵!!!!");
        System.out.println("获取数据:" + jedis.get("0420"));
    }

    @Test
    public void testCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.180.160", 7000));
        nodes.add(new HostAndPort("192.168.180.160", 7001));
        nodes.add(new HostAndPort("192.168.180.160", 7002));
        nodes.add(new HostAndPort("192.168.180.160", 7003));
        nodes.add(new HostAndPort("192.168.180.160", 7004));
        nodes.add(new HostAndPort("192.168.180.160", 7005));

        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("0421", "redis集群搭建完成!!!!");
        System.out.println(cluster.get("0421"));
    }

}
