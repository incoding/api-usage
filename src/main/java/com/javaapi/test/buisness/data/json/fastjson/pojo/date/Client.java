package com.javaapi.test.buisness.data.json.fastjson.pojo.date;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by user on 2019/1/8
 */
public class Client {
    @Test
    public void test() {
        String s = "{\n" +
                "\"start\": \"2019-01-08 18:18:25\",\n" +
                "\"end\": \"2019-01-08 18:18:27\"\n" +
                "}";
        TimeLimit parse = JSON.parseObject(s,TimeLimit.class);
        System.out.println("parse = " + parse);
    }
}
