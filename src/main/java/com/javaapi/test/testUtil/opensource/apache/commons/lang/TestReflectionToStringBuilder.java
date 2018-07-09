package com.javaapi.test.testUtil.opensource.apache.commons.lang;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**q
 * Created by user on 15/8/16.
 */
public class TestReflectionToStringBuilder {
    /**
     * 可以反射生成toString,是唯一一个可以不用一个一个字段写上去的toString实现
     */
    @Test
    public void test(){
        Person p = new Person();
        p.setAge("18");
        p.setName("kk");
        String s = ReflectionToStringBuilder.toString(p);
        System.out.println(s);
    }
    @Test
    public void testToStringBuilder() {
        Person p = new Person();
        p.setAge("18");
        p.setName("kk");

        Person p2 = new Person();
        p2.setAge("18");
        p2.setName("kk");
        ArrayList<Person> list = new ArrayList<>();
        list.add(p2);
        p.setList(list);
        System.out.println("p = " + p);
    }

    @Test
    public void testName() throws Exception {


    }


    /*不可以打印list中的对象*/
    @Test
    public void testList() {
        List<Person> list = new ArrayList<>();
        String s = ReflectionToStringBuilder.toString(list);
        System.out.println(s);
        String s1 = ReflectionToStringBuilder.reflectionToString(list);
        System.out.println("s1 = " + s1);
    }

}
