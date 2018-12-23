package com.javaapi.test.util.math.algorithm.sort.merge.lession3;

import com.javaapi.test.util.math.algorithm.sort.merge.lession2.ArrayReplace;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2018/12/23
 */
public class ArraySplit {

    @Test
    public void testSplitDisplay() {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSortDisplay(a, 0, a.length - 1);
    }

    public static void mergeSortDisplay(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            System.out.print("low array startIndex = " + low + " end index = " + mid);
            System.out.print(" array in low array ");
            for (int i = low; i <= mid; i++) {
                System.out.print(a[i] + ",");
            }
            System.out.println();
            System.out.print("high array startIndex = " + (mid + 1) + " end index = " + high);
            System.out.print(" array in high array ");
            for (int i = mid + 1; i <= high; i++) {
                System.out.print(a[i] + ",");
            }
            System.out.println();
            System.out.println("=================");
            // 左边
            mergeSortDisplay(a, low, mid);
            // 右边
            mergeSortDisplay(a, mid + 1, high);
        }
    }

    @Test
    public void testSplit() {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("a = " + Arrays.toString(a));
    }

    private void mergeSort(int[] a, int low,int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            ArrayReplace.merge(a, low, mid, high);
        }

    }

}
