package com.javaapi.test.application.cache.redis.jedis;

/**
 * Created by user on 15/8/23.
 */

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.*;

public class TestRedis {
    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
//        jedis.auth("admin");
    }

    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------
        jedis.set("name", "kk");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin
        //
        jedis.append("name", "nima"); //拼接
        System.out.println(jedis.get("name"));
        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name", "111111", "age", "23", "qq", "476777389");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap() {
        //-----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user", map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);

        //删除map中的某个键值
        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList() {
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, 1));
        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet() {
        //添加
        jedis.sadd("user", "liuling");
        jedis.sadd("user", "xinxin");
        jedis.sadd("user", "ling");
        jedis.sadd("user", "zhangxinxin");
        jedis.sadd("user", "who");
        //移除noname
        jedis.srem("user", "who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }
    @Test
    public  void sortedSet() {
        System.out.println("==SoretedSet==");
//        Jedis jedis = RedisUtil.getJedis();
        try {
            jedis.zadd("hackers", 1940, "Alan Kay");
            jedis.zadd("hackers", 1953, "Richard Stallman");
            jedis.zadd("hackers", 1965, "Yukihiro Matsumoto");
            jedis.zadd("hackers", 1916, "Claude Shannon");
            jedis.zadd("hackers", 1969, "Linus Torvalds");
            jedis.zadd("hackers", 1912, "Alan Turing");
            Set<String> setValues = jedis.zrange("hackers", 0, -1);
            System.out.println(setValues);
            Set<String> setValues2 = jedis.zrevrange("hackers", 0, -1);
            System.out.println(setValues2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 清空数据
        System.out.println(jedis.flushDB());
        // 添加数据
        jedis.zadd("zset", 10.1, "hello");
        jedis.zadd("zset", 10.0, ":");
        jedis.zadd("zset", 9.0, "zset");
        jedis.zadd("zset", 11.0, "zset!");
        // 元素个数
        System.out.println(jedis.zcard("zset"));
        // 元素下标
        System.out.println(jedis.zscore("zset", "zset"));
        // 集合子集
        System.out.println(jedis.zrange("zset", 0, -1));
        // 删除元素
        System.out.println(jedis.zrem("zset", "zset!"));
        System.out.println(jedis.zcount("zset", 9.5, 10.5));
        // 整个集合值
        System.out.println(jedis.zrange("zset", 0, -1));
    }

    @Test
    public void test() throws InterruptedException {
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    @Test
    public void testRedisPool() {
        RedisUtil.getJedis().set("newname", "中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
//     @Test
//    public void test2() {
//
//         int ipLoginTimes = limitIpUserIdTimes(null, "127.0.0.1", 111, "ipLoginTimes");
//         System.out.println("ipLoginTimes = " + ipLoginTimes);
//
//     }
//    private int limitIpUserIdTimes(Jedis jedis2, String ip, int userId,String key) {
//        if(StringUtils.isBlank(ip)){
//            System.out.println("IP is blank.");
//        }
//        int times = jedis.hincrBy(key,ip+":"+userId,1).intValue();
//        if(times == 1 ){
//            jedis.expireAt(key, getTomorrowTime());
//        }
//        return times;
//    }
//
//    /**
//     * 获得明天0点的UNIX TIMESTAMP
//     *
//     * @return
//     */
//    public static long getTomorrowTime() {
//        return LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toEpochSecond();
//    }


}