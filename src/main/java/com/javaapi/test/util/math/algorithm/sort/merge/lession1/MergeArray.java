package com.javaapi.test.util.math.algorithm.sort.merge.lession1;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1 合并数组
 * 2  2个有序子数组,合并为一个有序大数组
 */
public class MergeArray {

    /**
     * 因为 java 获取数组范围外索引的值会直接报错
     */
    @Test
    public void testGetOutOfBounds() {
        int[] a = {1, 2, 5, 6, 8};
        int c = a[10];
        System.out.println("c = " + c);
    }

    /**
     * 合并2个数组
     * 1 通过for 遍历2个数组拥有相同索引的部分(避免数组越界),放入新数组
     * 2 如果2个数组大小不一致,则通过for 遍历大数组,放入新数组
     * <p>
     * <p>
     * <p>
     * 如果2个数组都有序,并且合并后也是有顺序的应该怎么办?
     */
    @Test
    public void testMerge() {
        int[] a = {1, 2, 5, 6, 8};
        int[] b = {3, 4, 5, 7, 8, 9};

        int newLenght = a.length + b.length;
        int[] minArr;
        int[] maxArr;
        if (a.length >= b.length) {
            minArr = b;
            maxArr = a;
        } else {
            minArr = a;
            maxArr = b;
        }
        int[] c = new int[newLenght];
        int newIndex = 0;
        for (int i = 0; i < minArr.length; i++) {
            if (a[i] < b[i]) {
                c[newIndex++] = a[i];
                c[newIndex++] = b[i];
            } else {
                c[newIndex++] = b[i];
                c[newIndex++] = a[i];
            }
        }
        if (minArr.length != maxArr.length) {
            for (int j = minArr.length; j < maxArr.length; j++) {
                c[newIndex++] = maxArr[j];
            }
        }
        System.out.println("新数组为" + Arrays.toString(c));
    }


    /**
     * 2个有序数组合a,b(从小到大)并为一个有序数组
     * 1 每次从a数组中选出最小值,与b数组中的最小值比较(因为数组是有序的,所以只要选择最左侧的就是最小值)
     * 2 a与b比较的较小者放入新数组.
     * 3 注意处理 有a数组都放入新数组,但是b数组还剩余的情况,这是因为a中数组所有数据都比b数组中小, 反之同理
     *
     */
    @Test
    public void test() {
        int[] a = {1, 2, 5, 6, 8};
        int[] b = {1, 3, 8, 9, 10};
        // 新数组长度
        int[] temp = new int[a.length + b.length];
        int tempIndex = 0;
        int aIndex = 0;
        int bIndex = 0;
        System.out.println("temp = " + Arrays.toString(temp));
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) {
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
        int[] a = {1, 2, 5, 6, 8};
        int[] b = {10, 30, 70, 80, 90};
        merge2(a, b);
    }

    /**
     * 合并2个数组 抽象出方法 ,并把剩余数据放入数组
     */
    @Test
    public void test3() {
        int[] a = {1, 2, 5, 6, 8};
        int[] b = {10, 30, 70, 80, 90};
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
