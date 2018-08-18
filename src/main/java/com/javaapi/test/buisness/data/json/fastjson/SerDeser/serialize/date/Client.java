package com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.date;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

/**
 * -------------------------------------------
 * |   @author      ||
 * -------------------------------------------
 * |    @date       |18/3/25 下午5:29          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 */
public class Client {

    /**
     * fastjson 序列化默认是时间戳
     */
    @Test
    public void testDefault(){
        StudentForSer studentForSer = new StudentForSer();
        String s = JSON.toJSONString(studentForSer);
        System.out.println("s = " + s);
    }
    /**
     * fastjson  jsonfield 注解的 format 属性
     */
    @Test
    public void testJsonFieldFormat(){
        StudentForDeser studentForDeser = getStudentForDeser();
        String s = JSON.toJSONString(studentForDeser);
        System.out.println("s = " + s);
    }

    private StudentForDeser getStudentForDeser() {
        StudentForDeser studentForDeser = new StudentForDeser();
        studentForDeser.setDate(new Date());
        studentForDeser.setName("hi");
        return studentForDeser;
    }
}
