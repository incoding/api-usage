package com.javaapi.test.businessdesign.skill.bit.base;

import org.junit.Test;

/**
 * Created by user on 2018/9/16
 */
public class TestAnd {


    /**
     * 与 操作
     */
    @Test
    public void test2(){
        String bitStr = "111";
        int i = Integer.parseInt(bitStr, 2);
        System.out.println("i = " + i);
        int i2 = i & 16;
        System.out.println("i2 = " + i2);
    }

}
