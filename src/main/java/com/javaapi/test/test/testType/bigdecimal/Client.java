package com.javaapi.test.test.testType.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by user on 18/3/28
 */
public class Client {
    @Test
    public void test(){
        String  s ="32.24";
        BigDecimal bigDecimal = new BigDecimal(s);
        System.out.println("bigDecimal = " + bigDecimal.intValue());

    }
    @Test
    public void test2(){
        Long num = null;
        BigDecimal bigDecimal = BigDecimal.valueOf(num);
        System.out.println("bigDecimal = " + bigDecimal);

    }
}
