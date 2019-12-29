package com.javaapi.test.util.math.algorithm.sort.quick;

import org.junit.Test;

/**
 * Created by user on 2018/11/29
 */
public class QuickSort {

    @Test
    public void test() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low == high) {
            return;
        }
        int pivot = a[(high + low) / 2];
        int leftIndex = low;
        int rightIndex = high;


    }
}
