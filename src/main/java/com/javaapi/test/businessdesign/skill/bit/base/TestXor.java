package com.javaapi.test.businessdesign.skill.bit.base;

import org.junit.Test;


public class TestXor {
    /**
     * 异或 相同为真，不同为假
     */
    @Test
    public void test(){
        int a1 = 3;
        int a2 = 2;
        System.out.println("a1 = " + Integer.toBinaryString(a1));
        System.out.println("a2 = " + Integer.toBinaryString(a2));
        Integer a = a1 ^ a2;
        System.out.println(a+"="+Integer.toBinaryString(a));

        int b1 = 4;
        int b2 = 2;
        System.out.println("b1 = " + Integer.toBinaryString(b1));
        System.out.println("b2 = " + Integer.toBinaryString(b2));
        Integer b = b1 ^ b2;
        System.out.println("b = " + Integer.toBinaryString(b));
    }

}
