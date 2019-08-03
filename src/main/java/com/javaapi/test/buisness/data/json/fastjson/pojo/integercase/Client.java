package com.javaapi.test.buisness.data.json.fastjson.pojo.integercase;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by user on 2019/7/2
 */
public class Client {

    @Test
    public void test(){
        String str = "{\n" +
                "  \"id\": 1,\n" +
                "  \"balance\": 22.13\n" +
                "}";
        Student student = JSON.parseObject(str, Student.class);
        System.out.println("student = " + student);
    }
}
