package com.javaapi.test.buisness.data.json.fastjson.pojo.bigdecimal;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * big decimal 输出的是 json的数字
 */
public class Client {
    @Test
    public void test(){
        Student student = new Student();
        student.setBalance(new BigDecimal(200));
        student.setId(1);
        String s = JSON.toJSONString(student);
        System.out.println("s = " + s);
    }
}
