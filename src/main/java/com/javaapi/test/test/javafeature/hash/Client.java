package com.javaapi.test.test.javafeature.hash;

import org.junit.Test;

/**
 * Created by user on 2018/8/23
 */
public class Client {
    @Test
    public void test(){
        Object o = new Object();
        System.out.println("o = " + o.hashCode());
    }

    /**
     * 重写equals要重写hashcode 方法
     * @throws Exception
     */
    @Test
    public void testHash() throws Exception {
        School school = new School();
        school.setId(1);
        school.setName("kk");

        System.out.println("school = " + school.hashCode());

    }
}
