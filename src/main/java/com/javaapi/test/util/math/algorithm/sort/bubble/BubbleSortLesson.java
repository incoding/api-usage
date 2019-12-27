package com.javaapi.test.util.math.algorithm.sort.bubble;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2019/12/25
 */
public class BubbleSortLesson {

    @Test
    public void test() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0};
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
