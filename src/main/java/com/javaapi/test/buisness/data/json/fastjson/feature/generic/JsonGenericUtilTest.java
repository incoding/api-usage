package com.javaapi.test.buisness.data.json.fastjson.feature.generic;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.javaapi.test.buisness.data.json.fastjson.annotation.jsontype.Student;
import com.javaapi.test.buisness.joint.outter.Result;
import lombok.Data;
import org.junit.Test;

import java.util.List;

public class JsonGenericUtilTest {
    /**
     * 多级参数
     */
    @Test
    public void test(){
        Object result = JsonGenericUtil.parseListResult(getJson(), Student.class);
        System.out.println("result = " + result);
    }

    /**
     * 多级类型参数
     */
    @Test
    public void test2(){
        List<Class<?>> classes = com.google.common.collect.Lists.newArrayList(Result.class, List.class, Student.class);
        String json = getJson();
        System.out.println("json = " + json);
        Result<List<Student>> o = JsonGenericUtil.parseGeneric(json, classes.toArray(new Class[classes.size()]));
        System.out.println("o = " + o);
    }

    public static String getJson(){
        Student student = new Student();
        student.setName("this is name");
        Result<List<Student>> success = Result.success(Lists.newArrayList(student));
        return JSON.toJSONString(success);
    }

}
