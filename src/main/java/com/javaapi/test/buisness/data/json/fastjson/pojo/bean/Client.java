package com.javaapi.test.buisness.data.json.fastjson.pojo.bean;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by user on 2018/8/27
 */
public class Client {
    @Test
    public void testWriteIs(){
        Student student = new Student();
        student.setName("nihao");
        student.setPass(true);
        String s = JSON.toJSONString(student);
        System.out.println("s = " + s);
    }

    @Test
    public void testReadNotContainsIs(){
        String s = "{\"name\":\"nihao\",\"pass\":true}";
        Student student = JSON.parseObject(s, Student.class);
        System.out.println("student = " + student);
    }

    @Test
    public void testReadContainsIs(){
        String s = "{\"name\":\"nihao\",\"isPass\":true}";
        Student student = JSON.parseObject(s, Student.class);
        System.out.println("student = " + student);
    }
}
