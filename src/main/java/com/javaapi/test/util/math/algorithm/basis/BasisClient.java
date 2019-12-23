package com.javaapi.test.util.math.algorithm.basis;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2019/12/22
 */
public class BasisClient {
    /**
     * 2个int类型相除后赋值给int，结果默认向下取整
     */
    @Test
    public void testIntDivide() {
        int a = 6;
        int b = 5;
        int c = a / b;
        System.out.println("c = " + c);
    }

    /**
     * 2个变量交换,需要额外定义一个变量,才能腾出地方交换
     */
    @Test
    public void testSwap() {
        int[] a = {1};
        int[] b = {2};
        swap(a, b);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
    }

    /**
     * 三个数求最大值
     */
    @Test
    public void testMax() {
        int a = 10;
        int b = 30;
        int c = 20;
        int max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        System.out.println("max = " + max);
    }

    /**
     * 一个数组求最大值
     */
    @Test
    public void test() {
        int[] a = {1, 8, 2, 5, 7};
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("max = " + max);
    }


    private void swap(int[] a, int[] b) {
        int temp = a[0];
        a[0] = b[0];
        b[0] = temp;
    }
}
