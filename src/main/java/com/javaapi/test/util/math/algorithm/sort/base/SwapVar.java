package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

/**
 * 快速排序 第一课
 * Created by user on 2018/11/30
 */
public class SwapVar {
    /**
     * 交换变量
     */
    @Test
    public void test() {
        Integer a = 1;
        Integer b = 2;

        // 交换变量  注意不能通过方法交换
        Integer c = a;

        a = b ;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    @Test
    public void testSwap() {
        Integer a = 1;
        Integer b = 2;

        // 交换变量  注意不能通过方法交换
        swap(a, b);
        System.out.println("===========");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private void swap(Integer a, Integer b) {
        Integer c = a;
        a = b ;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}
