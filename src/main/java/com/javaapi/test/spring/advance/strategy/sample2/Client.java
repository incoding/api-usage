package com.javaapi.test.spring.advance.strategy.sample2;

import org.junit.Test;

/**
 * Created by user on 2018/8/25
 * refer
 * https://blog.csdn.net/nethackatschool/article/details/69293531
 * getClass().isAssignableFrom(baseObj.getClass())
 */
public class Client {
    @Test
    public void test(){
        int i = "nihao".hashCode();
        System.out.println("i = " + i);
    }
}
