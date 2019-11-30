package com.javaapi.test.util.math.number.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by user on 2018/7/25
 */
public class TestBigDecimalOperation {

    /**
     * 加-负数
     */
    @Test
    public void testAddNegative() {
        BigDecimal bigDecimal = new BigDecimal("5");
        BigDecimal add = bigDecimal.add(new BigDecimal("-3"));
        System.out.println("add = " + add);
    }

}
