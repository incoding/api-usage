package com.javaapi.test.buisness.skill.bit.base;

import org.junit.Test;

/**
 * Created by user on 2018/9/16
 */
public class TestBit4 {
    /**
     *
     */
    @Test
    public void test(){
        String bitStr = "111";
        int i = Integer.parseInt(bitStr, 2);
        System.out.println("i = " + i);
    }

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

    /**
     * 或 操作
     */
    @Test
    public void test3(){
        String bitStr = "111";
        int bit1 = Integer.parseInt(bitStr, 2);
        System.out.println("i = " + bit1);

        String bitStr2 = "1000";
        int bit2 = Integer.parseInt(bitStr2, 2);
        System.out.println("bit2 = " + bit2);
        int bit3 = bit1 | bit2;
        System.out.println("bit3 = " + bit3);
    }
}
