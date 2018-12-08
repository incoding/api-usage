package com.javaapi.test.util.math.algorithm.sort.lession;

import org.junit.Test;

import java.util.Arrays;

/**
 * 算法基础 第一课
 * Created by user on 2018/11/30
 */
public class SwapVar {
    /**
     * 交换变量 同一方法内 ,
     * 1 把前一个变量存到临时变量里
     * 2 第二个变量赋值到第一个变量
     * 3 第一步的临时变量赋值给第二个变量
     */
    @Test
    public void test() {
        Integer a = 1;
        Integer b = 2;

        // 交换变量  注意不能通过方法交换
        Integer c = a;

        a = b;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    /**
     * 交换变量  注意不能通过方法交换
     */
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

    @Test
    public void testSwapArrInSameMethod(){
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        System.out.println("a = " + Arrays.toString(a));
        int temp = a[0];
        a[0] = a[7];
        System.out.println("a = " + Arrays.toString(a));
        a[7] = temp;
        System.out.println("a = " + Arrays.toString(a));
    }

    /**
     * 交换变量 通过数组
     */
    @Test
    public void testSwapArrOtherMethod() {
        int[] arr = {1, 3, 5, 7};
        System.out.println("arr = " + Arrays.toString(arr));
        swap(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    private void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;

    }


    private void swap(Integer a, Integer b) {
        Integer c = a;
        a = b;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}
