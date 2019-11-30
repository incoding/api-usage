package com.javaapi.test.util.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Created by user on 18/4/19
 */
public class MathUtil2 {

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        if (a == null) {
            a = BigDecimal.ZERO;
        }
        if (b == null) {
            b = BigDecimal.ZERO;
        }
        return a.multiply(b);
    }

    public static BigDecimal plus(BigDecimal a, BigDecimal b) {
        if (a == null) {
            a = BigDecimal.ZERO;
        }
        if (b == null) {
            b = BigDecimal.ZERO;
        }
        return a.add(b);
    }

    public static Integer plus(Integer a, Integer b) {
        if (a == null) {
            a = 0;
        }
        if (b == null) {
            b = 0;
        }
        return a + b;
    }

    public static Long plus(Long a, Long b) {
        if (a == null) {
            a = 0L;
        }
        if (b == null) {
            b = 0L;
        }
        return a + b;
    }

    public static BigDecimal divide(BigDecimal refundRate, BigDecimal divisor) {
        if (refundRate == null) {
            return BigDecimal.ZERO;
        }
        if (BigDecimal.ZERO.equals(refundRate)) {
            return refundRate;
        }
        if (BigDecimal.ZERO.equals(divisor)) {
            return divisor;
        }
        BigDecimal divide = refundRate.divide(divisor, 4, BigDecimal.ROUND_HALF_UP);
        return divide;
    }

    public static Integer divide(Integer refundRate, Integer size) {
        if (refundRate == null) {
            refundRate = 0;
        }
        BigDecimal divide = divide(new BigDecimal(refundRate), new BigDecimal(size));
        return divide.intValue();
    }

    public static String getPercentString(BigDecimal number) {
        if (number == null) {
            return "0";
        }
        NumberFormat nf = NumberFormat.getPercentInstance();
        // 取2位小数,对第三位四舍五入
        nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(2);
        String format = nf.format(number);
        return format;
    }

    /**
     * 根据 paymentAmount 和rate 比例,算出 实际数值
     * <p>
     * rate   类似 为 1:1  ,或1:2 ,或1:10 之类的字符串
     *
     * @param paymentAmount
     * @param rate
     * @return
     */
    public static BigDecimal computeByRate(BigDecimal paymentAmount, String rate) {
        String[] split = rate.split(":");
        String molecular = split[0];
        String denominator = split[1];

        BigDecimal result = new BigDecimal(denominator).multiply(paymentAmount).divide(new BigDecimal(molecular));
        result = result.setScale(0, RoundingMode.DOWN);
        return result;
    }

}
