package com.javaapi.test.util.math.algorithm.sort.swap.quick;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2018/11/29
 */
public class QuickSort {

    /**
     * 递归形式1  手写
     */
    @Test
    public void test() {
        int[] a = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int leftIndex = low;
        int rightIndex = high;
        int temp = a[leftIndex];
        while (leftIndex < rightIndex) {
            while (a[rightIndex] > temp && leftIndex < rightIndex) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                a[leftIndex] = a[rightIndex];
                leftIndex++;
            }
            while (a[leftIndex] < temp && leftIndex < rightIndex) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                a[rightIndex] = a[leftIndex];
                rightIndex--;
            }
        }
        a[leftIndex] = temp;
        quickSort(a, low, leftIndex - 1);
        quickSort(a, leftIndex + 1, high);
    }





}
