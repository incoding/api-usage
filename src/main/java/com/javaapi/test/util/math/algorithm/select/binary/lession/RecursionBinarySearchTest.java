package com.javaapi.test.util.math.algorithm.select.binary.lession;

import org.junit.Test;

/**
 * Created by user on 2019/12/22
 */
public class RecursionBinarySearchTest {
    int[] a = {2, 4, 9, 15, 24, 35, 44, 56, 62, 78, 93};

    @Test
    public void testHigh() {
        int b = 93;
        int i = binarySearch(a, 0, a.length - 1, b);
        System.out.println("i = " + i);
    }

    @Test
    public void testHighMiss() {
        int b = 100;
        int i = binarySearch(a, 0, a.length - 1, b);
        System.out.println("i = " + i);
    }

    @Test
    public void testLow() {
        int b = 2;
        int i = binarySearch(a, 0, a.length - 1, b);
        System.out.println("i = " + i);
    }

    @Test
    public void testLowMiss() {
        int b = 0;
        int i = binarySearch(a, 0, a.length - 1, b);
        System.out.println("i = " + i);
    }


    private int binarySearch(int[] a, int low, int high, int value) {
        int mid = (low + high) / 2;
        if (value == a[mid]) {
            return value;
        }
        if (mid < low || mid > high) {
            return -1;
        }
        if (value < a[mid]) {
            return binarySearch(a, low, mid - 1, value);
        } else {
            return binarySearch(a, mid + 1, high, value);
        }
    }
}
