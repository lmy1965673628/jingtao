package com.ly.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class TestRedis {
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
        jedis.lpush("list", "1","2","3","4");
        System.out.println(jedis.rpop("list"));
    }

}
