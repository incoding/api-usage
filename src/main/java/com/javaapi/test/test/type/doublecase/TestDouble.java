package com.javaapi.test.test.type.doublecase;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by user on 17/6/1.
 */
public class TestDouble {
    @Test
    public void test(){
        Double a = new Double(1980);
        changeDouble(a);
        System.out.println("a = " + a.toString());
    }

    private void changeDouble(Double a) {
        a = new Double(2080);
        System.out.println("a = " + a);
        Double.valueOf(1);
    }


    @Test
    public void test2(){
        Double a = new Double(1980);
        a = new Double(2020);
        System.out.println("a = " + a);
    }

    @Test
    public void testEquals(){
        Double a = 0d;
        System.out.println("a = " + a);

        Double b = 0.00d;
        System.out.println("b = " + a.equals(b));
        Double doubleZero = NumberUtils.DOUBLE_ZERO;

    }
}
