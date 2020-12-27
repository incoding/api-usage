package com.javaapi.test.businessdesign.skill.bit.base;

import org.junit.Test;

/**
 * Created by user on 2020/12/27.
 */
public class TestOr {

    /**
     * 或 操作
     */
    @Test
    public void test3() {
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
