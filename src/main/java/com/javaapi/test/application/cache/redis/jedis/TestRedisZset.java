package com.javaapi.test.application.cache.redis.jedis;

/**
 * Created by user on 15/8/23.
 */

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Set;

//import java.time.LocalDate;
//import java.time.ZoneId;

public class TestRedisZset {
    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("redis-s35.infra.xxx.com", 6380);
        //权限认证
//        jedis.auth("admin");
    }

    /**
     * 获取所有的
     */
    @Test
    public void testZrangeWithScores() {
        Set<Tuple> tuples = jedis.zrangeWithScores("myzset", 0, -1);
        for (Tuple tuple : tuples) {
            String element = tuple.getElement();
            double score = tuple.getScore();
            System.out.println("element ="+element+",score ="+score);
        }

    }


    /**
     * 反向的zRange操作
     */
    @Test
    public void testZrevrangeWithScores() {
        Set<Tuple> tuples = jedis.zrevrangeWithScores("myzset", 0, -1);
        for (Tuple tuple : tuples) {
            String element = tuple.getElement();
            double score = tuple.getScore();
            System.out.println("element ="+element+",score ="+score);
        }

    }

    /**
     * 反向的zRange操作
     */
    @Test
    public void testPipeLineGet() {
        Pipeline p = jedis.pipelined();
        for (int i = 0; i < 10; i++) {

            p.get("qq" + i);
        }
        List<Object> objects = p.syncAndReturnAll();
    }


    @Test
    public void testPipeLineSetExpire() {
        Pipeline p = jedis.pipelined();
        for (int i = 0; i < 10; i++) {

            p.set("qq" + i, "" + i);
        }

        p.expire("qq1", 300);
        p.sync();


    }
    @Test
    public void test() {
        Object a = null;
        String b = (String) a;
        System.out.println("b = " + b);
    }

    /**
     * zset exist
     */
    @Test
    public void testZsetExist() {
        Boolean exists = jedis.exists("user:id:2062107:content:zset");
        System.out.println("exists = " + exists);
    }




}