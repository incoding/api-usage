package com.javaapi.test.businessdesign.skill.bit.base;

import org.junit.Test;

/**
 * Created by user on 2020/12/27.
 */
public class TestBinaryToDecimal {
    /**
     *
     */
    @Test
    public void test() {
        String bitStr = "111";
        int i = Integer.parseInt(bitStr, 2);
        System.out.println("i = " + i);
    }
}
