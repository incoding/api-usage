package com.javaapi.test.util.math.algorithm.sort.merge.pratice;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2019/12/28
 */
public class MergeSort {
    @Test
    public void test() {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("结果" + Arrays.toString(a));
    }

    private void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int newLength = (high - low + 1);
        int[] c = new int[newLength];
        int totalIndex = 0;
        int leftIndex = low;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= high) {
            if (a[leftIndex] < a[rightIndex]) {
                c[totalIndex++] = a[leftIndex++];
            } else {
                c[totalIndex++] = a[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            c[totalIndex++] = a[leftIndex++];
        }

        while (rightIndex <= high) {
            c[totalIndex++] = a[rightIndex++];
        }

        for (int k2 = 0; k2 < totalIndex; k2++) {
            a[low + k2] = c[k2];
        }
    }
}
