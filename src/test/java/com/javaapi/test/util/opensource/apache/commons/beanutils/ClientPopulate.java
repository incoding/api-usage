package com.javaapi.test.util.opensource.apache.commons.beanutils;

import com.google.common.collect.Maps;
import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.School;
import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.testng.collections.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * map 转pojo 实例
 */
public class ClientPopulate {
    @Test
    public void populateOneLayer(){
        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("name", "nihao");
        objectObjectHashMap.put("age", 31);
        objectObjectHashMap.put("birthday", new Date());
        try {
            Student bean = new Student();
            BeanUtils.populate(bean, objectObjectHashMap);
            System.out.println("bean = " + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwoLayer(){
        School school = new School();
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("name", "senior school");
        Student student = new Student();
        student.setName("nihao");
        student.setBirthday(new Date());
        properties.put("students", Lists.newArrayList(student));
        try {
            BeanUtils.populate(school, properties);
            System.out.println("school = " + school);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testTwoLayer_v2(){
        School school = new School();
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("name", "senior school");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name", "nihao");
        objectObjectHashMap.put("age", 31);
        objectObjectHashMap.put("birthday", new Date());

        properties.put("students", Lists.newArrayList(objectObjectHashMap));
        try {
            BeanUtils.populate(school, properties);
            System.out.println("school = " + school);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
