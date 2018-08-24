package com.javaapi.test.buisness.data.json.fastjson.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.javaapi.test.application.cache.redis.User;
import com.javaapi.test.application.cache.redis.jedis.SeriUtil.FastJsonSerializeUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 15/8/24.
 */
public class Client {

    /**
     * 测试序列化，反序列化单一对象
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testSerDeSer() throws UnsupportedEncodingException {
        User user =new User();
        user.setName("kk");
        user.setCreateTime(new Date());
        byte[] serialize = FastJsonSerializeUtil.serialize(user);
        System.out.println("new String(serialize) = " + new String(serialize, "UTF-8"));
        User unserialize = (User) FastJsonSerializeUtil.deserialize(serialize, User.class);
        System.out.println("deserialize = " + unserialize);
    }


    @Test
    public void testSerDeSerArrayByTypeReference() throws UnsupportedEncodingException {

        User user = new User();
        user.setName("kk");
        user.setCreateTime(new Date());
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        long start = System.currentTimeMillis();
        byte[] serialize = FastJsonSerializeUtil.serialize(list);
        long start1 = System.currentTimeMillis();
        System.out.println("start1 = " + (start1 - start));
        List<User> newList = JSON.parseObject(new String(serialize), new TypeReference<List<User>>() {
        });
        System.out.println("newList = " + newList);
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end-start1));

    }
    @Test
    public void testSerDeSerArrayByParseArray() throws UnsupportedEncodingException {

        User user = new User();
        user.setName("kk");
        user.setCreateTime(new Date());
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        long start = System.currentTimeMillis();
        byte[] serialize = FastJsonSerializeUtil.serialize(list);
        long start1 = System.currentTimeMillis();
        System.out.println("start1 = " + (start1-start));
        List<User> newList = FastJsonSerializeUtil.deserializeArray(serialize, User.class);
        System.out.println("newList = " + newList);
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end-start1));

    }
}
