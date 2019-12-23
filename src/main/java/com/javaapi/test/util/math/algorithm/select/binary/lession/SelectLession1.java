package com.javaapi.test.util.math.algorithm.select.binary.lession;

import org.junit.Test;

/**
 * Created by user on 2019/1/6
 */
public class SelectLession1 {
    /**
     * 获取中间值
     */
    @Test
    public void test() {
        int mid = getMid(0, 0);
        System.out.println("mid = " + mid);
        mid = getMid(2, 3);
        System.out.println("mid = " + mid);
        mid = getMid(3, 3);
        System.out.println("mid = " + mid);
    }

    /**
     * 注意 默认是向下取整   (2+3)/2  是得 2
     *
     * @param low
     * @param high
     * @return
     */
    private int getMid(int low, int high) {
        int mid = (low + high) / 2;
        return mid;
    }


    /**
     * 给定一个父数组,圈定一个子数组
     */
    @Test
    public void testSubArr() {
        int[] a = {10, 30, 80, 20, 60};
        getSubArr(a, 0, 0);
        System.out.println("========");
        getSubArr(a, a.length - 1, a.length - 1);
        System.out.println("========");
        getSubArr(a, 0, a.length - 1);
    }


    private void getSubArr(int[] a, int startIndex, int endIndex) {
        if (startIndex <= endIndex && endIndex <= a.length - 1) {
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.println("a[i] = " + a[i]);
            }
        }
    }
}
