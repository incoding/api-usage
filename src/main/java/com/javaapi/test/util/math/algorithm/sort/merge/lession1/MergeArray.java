package com.javaapi.test.util.math.algorithm.sort.merge.lession1;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并数组
 */
public class MergeArray {

    /**
     * 合并2个数组
     */
    @Test
    public void test() {
        int[] a = {1, 2, 5, 1, 8};
        int[] b = {9, 3, 8, 1, 7};
        int[] temp = new int[a.length + b.length];
        int tempIndex = 0;
        int aIndex = 0;
        int bIndex = 0;
        System.out.println("temp = " + Arrays.toString(temp));
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                temp[tempIndex++] = a[aIndex++];
            } else {
                temp[tempIndex++] = b[bIndex++];
            }
        }
        System.out.println("aIndex = " + aIndex);
        System.out.println("bIndex = " + bIndex);
        System.out.println("temp = " + Arrays.toString(temp));
    }

    /**
     * 合并2个数组 抽象出方法
     */
    @Test
    public void test2() {
        int[] a = {1, 2, 5, 1, 8};
        int[] b = {90, 30, 80, 10, 70};
        merge2(a, b);
    }

    /**
     * 合并2个数组 抽象出方法 ,并把剩余数据放入数组
     */
    @Test
    public void test3() {
        int[] a = {1, 2, 5, 1, 8};
        int[] b = {90, 30, 80, 10, 70};
        merge3(a, b);
    }



    private void merge2(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int tempIndex = 0;
        int aIndex = 0;
        int bIndex = 0;
        System.out.println("temp = " + Arrays.toString(temp));
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                temp[tempIndex++] = a[aIndex++];
            } else {
                temp[tempIndex++] = b[bIndex++];
            }
        }
        System.out.println("aIndex = " + aIndex);
        System.out.println("bIndex = " + bIndex);
        System.out.println("temp = " + Arrays.toString(temp));
    }

    private void merge3(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int tempIndex = 0;
        int aIndex = 0;
        int bIndex = 0;
        System.out.println("temp = " + Arrays.toString(temp));
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                temp[tempIndex++] = a[aIndex++];
            } else {
                temp[tempIndex++] = b[bIndex++];
            }
        }
        while (aIndex < a.length) {
            temp[tempIndex++] = a[aIndex++];
        }

        while (bIndex < b.length) {
            temp[tempIndex++] = b[bIndex++];
        }
        System.out.println("aIndex = " + aIndex);
        System.out.println("bIndex = " + bIndex);
        System.out.println("temp = " + Arrays.toString(temp));
    }
}
