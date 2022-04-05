package com.javaapi.test.util.number;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by user on 18/5/3
 */
public class ClientMathUtil {
    @Test
    public void test() {
        BigDecimal divide = divide(new BigDecimal(7), new BigDecimal(7 + 1095), 0);
        System.out.println("divide = " + divide);
    }



    public static BigDecimal divide(BigDecimal refundRate, BigDecimal divisor, int scale) {
        if (refundRate == null) {
            refundRate = BigDecimal.ZERO;
        }
        BigDecimal divide = refundRate.divide(divisor, scale, BigDecimal.ROUND_HALF_UP);
        return divide;
    }
}
