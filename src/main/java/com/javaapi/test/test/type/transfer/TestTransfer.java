package com.javaapi.test.test.type.transfer;

import org.junit.Test;

/**
 * Created by user on 2019/4/16
 */
public class TestTransfer {
    @Test
    public void testTransefer(){
        float i = 20f;
        int price = 100;
        int divisor = 300;
        float v = (i / divisor) * price;
        int result = (int) (price - v);
        System.out.println("v = " + v);
        System.out.println("result = " + result);
    }
}
