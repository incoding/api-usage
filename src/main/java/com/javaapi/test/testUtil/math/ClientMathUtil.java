package com.javaapi.test.testUtil.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by user on 18/5/3
 */
public class ClientMathUtil {
    @Test
    public void test() {
        BigDecimal divide = divide(new BigDecimal(7), new BigDecimal(7 + 1095));
        System.out.println("divide = " + divide);
    }



    public static BigDecimal divide(BigDecimal refundRate, BigDecimal divisor) {
        if (refundRate == null) {
            refundRate = BigDecimal.ZERO;
        }
        BigDecimal divide = refundRate.divide(divisor,4, BigDecimal.ROUND_HALF_UP);
        return divide;
    }
}
