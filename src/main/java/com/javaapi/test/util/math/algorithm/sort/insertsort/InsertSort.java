package com.javaapi.test.util.math.algorithm.sort.insertsort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    @Test
    public void test() {
        int[] a = {1, 2, 3, 8, 6, 5, 7, 9, 4, 0};
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (key < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // j+1因为,所以这里要把需要右侧位置跟key互换
            a[j + 1] = key;
            System.out.println("中间值为" + Arrays.toString(a));
        }
        System.out.println("结果为" + Arrays.toString(a));
    }

    @Test
    public void testFor() {
        int i = 0;
        for (; i < 10; i++) {
            if (i == 0) {
                break;
            }
        }
        System.out.println("i = " + i);

        for (; i < 10; i++) {

        }
        System.out.println("i = " + i);
    }
}
