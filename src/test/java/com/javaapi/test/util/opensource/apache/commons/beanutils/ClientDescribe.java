package com.javaapi.test.util.opensource.apache.commons.beanutils;


import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.School;
import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.StrangePojo;
import com.javaapi.test.util.opensource.apache.commons.beanutils.pojo.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.testng.collections.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;


/**
 *  pojo实例转map
 *  注意会放入一个class key在map中
 */
public class ClientDescribe {
    /**
     * 不做递归的话只能处理一层   也就是kv
     */
    @Test
    public void canDealOneLayer(){
        Student student = new Student();
        student.setAge(31);
        student.setBirthday(new Date());
        student.setName("nihao");
        describe(student);
    }

    @Test
    public void cannotDealTwoLayer(){
        School school = new School();
        Student student = new Student();
        student.setAge(31);
        student.setBirthday(new Date());
        student.setName("nihao");
        school.setStudents(Lists.newArrayList(student));
        describe(school);
    }

    /**
     * 单个字符的字段  大D会被描述为小d
     */
    @Test
    public void describeStrange(){
        StrangePojo strangePojo = new StrangePojo();
        strangePojo.setD("da D");
//        strangePojo.setDd("daxiao Dd");
        strangePojo.setDD("da DD");
//        strangePojo.setd("xiao d");
        describe(strangePojo);

    }

    private void describe(Object student) {
        try {
            Map<String, String> describe = BeanUtils.describe(student);
            System.out.println("describe = " + describe);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
