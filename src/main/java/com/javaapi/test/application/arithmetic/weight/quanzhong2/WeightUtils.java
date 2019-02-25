package com.javaapi.test.application.arithmetic.weight.quanzhong2;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 */
public class WeightUtils {
    /**
     * 根据权重列表随机选出一个来源,权重大的出现的概率高
     *
     * @param list
     * @return
     */
    public static <s extends Weight> s choose(List<s> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer weightSum = 0;
        for (s wc : list) {
            weightSum += wc.getWeight();
        }

        if (weightSum <= 0) {
            return null;
        }
        Random random = new Random();
        Integer n = random.nextInt(weightSum) + 1; // n in [1, weightSum]
        Integer m = 0;
        for (s wc : list) {
            if (m <= n && n <= m + wc.getWeight()) {
                return wc;
            }
            m += wc.getWeight();
        }
        return null;
    }

    @Test
    public void test() {

        BigDecimal divide = getDivide(new BigDecimal(2), new BigDecimal(100));
        System.out.println("divide = " + divide);

        BigDecimal divide2 = getDivide(new BigDecimal(3), new BigDecimal(1000));

        BigDecimal divide3 = getDivide(new BigDecimal(4), new BigDecimal(10000));

        BigDecimal add = getAdd(getAdd(divide, divide2), divide3);
        System.out.println("add = " + add);

    }
    @Test
    public void test2() {

        BigDecimal divide = getDivide(new BigDecimal(2), new BigDecimal(10000));
        System.out.println("divide = " + divide);
        int precision = divide.precision();
        int scale = divide.scale();
        System.out.println("scale = " + scale);


    }


    private BigDecimal getAdd(BigDecimal divide, BigDecimal divide2) {
        return divide.add(divide2);
    }


    private BigDecimal getDivide(BigDecimal fenZi, BigDecimal fenMu) {
        return fenZi.divide(fenMu);
    }


    @Test
    public void testLessThan1() {
        List<Weight> list = new ArrayList<>();
        Weight e = new Weight();
        e.setName("虚拟奖品");
//        e.setWeight(0.2);
        Weight e2 = new Weight();
        e2.setName("实际奖品");
        e2.setWeight(5);
        list.add(e);
        list.add(e2);
        Weight choose = choose(list);
        System.out.println("choose = " + choose);

    }

    @Test
    public void testNormal() {
        List<Weight> list = new ArrayList<>();
        Weight e = new Weight();
        e.setName("虚拟奖品");
        e.setWeight(10);
        Weight e2 = new Weight();
        e2.setName("实际奖品");
        e2.setWeight(5);
        list.add(e);
        list.add(e2);
        Weight choose = choose(list);
        System.out.println("choose = " + choose);
    }


}
