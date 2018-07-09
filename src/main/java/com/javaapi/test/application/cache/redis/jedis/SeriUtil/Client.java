package com.javaapi.test.application.cache.redis.jedis.SeriUtil;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15/8/23.
 */
public class Client {

    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
//        jedis.auth("admin");
    }


    @Test
    public void testJdkSer(){
        Person s = new Person(1,"nihaokk");
        jedis.set("jdkser".getBytes(),SerializeUtil.serialize(s));
        System.out.println("done");
    }

    @Test
    public void testJdkDser() throws Exception {
        if (jedis == null) {
            System.out.println("jedis = " + jedis);
        }
        byte[] bytes = jedis.get("jdkser".getBytes());
        Person unserialize = (Person) SerializeUtil.unserialize(bytes);
        System.out.println("deserialize = " + unserialize);
    }

    @Test
    public void testFastJsonSer() throws Exception {
        Person fastjson1 = new Person();
        fastjson1.setId(1);
        fastjson1.setName("fastjsonBytes");
        jedis.set("fastjson".getBytes(), serialize(fastjson1));
        jedis.set(FastJsonSerializeUtil.serialize("fastjson2"), serialize(fastjson1));

    }
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        SerializerFeature[] features = new SerializerFeature[0];
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
                serializer.config(feature, true);
            }

            serializer.write(object);
            return out.toBytes("UTF-8");
        } finally {
            out.close();
        }
    }
    @Test
    public void testFastJsonSer2() throws Exception {
        Person fastjson1 = new Person();
        fastjson1.setId(1);
        fastjson1.setName("fastjsonBytes");
        byte[] serialize = FastJsonSerializeUtil.serialize(fastjson1);
        System.out.println("serialize = " + serialize);
        String s = new String(serialize);
        System.out.println("s = " + s);
    }
    @Test
    public void testFastJsonDser() throws Exception {
        byte[] bytes = jedis.get("fastjson".getBytes());
        Person unserialize = (Person) FastJsonSerializeUtil.deserialize(bytes, Person.class);
        System.out.println("deserialize = " + unserialize);
    }

    /**
     * wrong
     * @throws Exception
     */
    @Test
    public void testName() throws Exception {
        List<Person> list = new ArrayList<>();
        Person e = new Person();
        e.setId(1);
        e.setName("kk");
        Person e2 = new Person();
        BeanUtils.copyProperties(e,e2);
        list.add(e);
        list.add(e2);
        byte[] serialize = FastJsonSerializeUtil.serialize(list);
        Object deserialize = FastJsonSerializeUtil.deserialize(serialize, List.class);
        System.out.println("deserialize = " + deserialize);
    }

    @Test
    public void testSerArray() throws Exception {
        List<Person> list = new ArrayList<>();
        Person e = new Person();
        e.setName("kk");
        Person e2 = new Person();
        BeanUtils.copyProperties(e, e2);
        list.add(e);
        list.add(e2);
        byte[] serialize = FastJsonSerializeUtil.serialize(list);
        List<Person> persons = FastJsonSerializeUtil.deserializeArray(serialize, Person.class);
        System.out.println("persons = " + persons);
    }
}
