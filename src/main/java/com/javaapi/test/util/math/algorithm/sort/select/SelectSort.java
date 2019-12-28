package com.javaapi.test.util.math.algorithm.sort.select;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2019/12/27
 */
public class SelectSort {
    /**
     * 1 外层循环每次确定一个位置
     * 2 内层循环,遍历除外层循环位置的其余位置,跟外层循环位置比较,获取一个最大值
     * 3 如果内层循环比外层循环大,则交换位置
     * 4 依次对接下来的位置做1,2,3部操作
     */
    @Test
    public void test() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0};
        for (int i = a.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
