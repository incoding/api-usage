package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序第五课
 * 同一个数组 交换 2个位置交换数据
 */
public class SwapArr {
    @Test
    public void testSwap(){
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        System.out.println("a = " + Arrays.toString(a));
        int temp = a[0];
        a[0] = a[7];
        System.out.println("a = " + Arrays.toString(a));
        a[7] = temp;
        System.out.println("a = " + Arrays.toString(a));
    }
}
