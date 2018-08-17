package com.javaapi.test.testUtil.math.number.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by user on 2018/7/25
 */
public class TestBigDecimalOperation {

    /**
     * 加-负数
     */
    @Test
    public void testAddNegative(){
        BigDecimal bigDecimal = new BigDecimal("5");
        BigDecimal add = bigDecimal.add(new BigDecimal("-3"));
        System.out.println("add = " + add);
    }

    @Test
    public void testComputeByRate() {
        BigDecimal bigDecimal = computeByRate(new BigDecimal("4"), "2:5");
        System.out.println("bigDecimal = " + bigDecimal);
    }

    public BigDecimal computeByRate(BigDecimal paymentAmount, String rate) {
        String[] split = rate.split(":");
        String molecular = split[0];
        String denominator = split[1];

        BigDecimal result = new BigDecimal(denominator).multiply(paymentAmount).divide(new BigDecimal(molecular));
        result = result.setScale(0, RoundingMode.DOWN);
        return result;
    }


}
