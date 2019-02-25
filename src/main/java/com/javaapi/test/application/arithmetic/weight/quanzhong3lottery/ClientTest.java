package com.javaapi.test.application.arithmetic.weight.quanzhong3lottery;

import com.javaapi.test.application.arithmetic.weight.quanzhong2.WeightUtils;
import com.javaapi.test.util.math.MathUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by user on 17/1/9.
 */
public class ClientTest {
    @Test
    public void test() {
        Gift banana8 = new Gift(1, "香蕉8", 2, 100);
        Gift banana18 = new Gift(2, "香蕉18", 3, 1000);
        Gift banana28 = new Gift(3, "香蕉28", 4, 10000);
        ArrayList<Gift> ls = new ArrayList<>();
        ls.add(banana8);
        ls.add(banana18);
        ls.add(banana28);
        Gift gift = lottery(ls);
        System.out.println("gift = " + gift);
    }

    @Test
    public void test2() {
        BigDecimal bigDecimal = new BigDecimal("0.001");
        System.out.println("bigDecimal = " + bigDecimal.scale());
        BigDecimal bigDecimal1 = new BigDecimal("1").movePointRight(bigDecimal.scale());
        System.out.println("bigDecimal1 = " + bigDecimal1);

    }

    private Gift lottery(ArrayList<Gift> ls) {
        int maxDenominator = ls.stream().max((s1, s2) -> {
            return s1.getDenominator() - s2.getDenominator();
        }).get().getDenominator();

        int allPrizeWeight = 0;
        for (Gift gift : ls) {
            int scale = new BigDecimal(maxDenominator).precision() - 1;
            String div = MathUtil.div(String.valueOf(gift.getNumerator()), String.valueOf(gift.getDenominator()), scale);
            String mul = MathUtil.mul(div, String.valueOf(maxDenominator), 0);

            int tmpWeight = Integer.parseInt(mul);
            allPrizeWeight += tmpWeight;
            gift.setWeight(tmpWeight);
        }
        Gift unPrize = new Gift(-1, "未中奖", maxDenominator - allPrizeWeight, maxDenominator);
        unPrize.setWeight(maxDenominator - allPrizeWeight);
        ls.add(unPrize);
        Gift choose = WeightUtils.choose(ls);
        if (choose.getId() == -1) {
            return null;
        }
        return choose;
    }
}
