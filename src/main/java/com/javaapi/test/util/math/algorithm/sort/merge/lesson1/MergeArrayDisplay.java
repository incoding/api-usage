package com.javaapi.test.util.math.algorithm.sort.merge.lesson1;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2018/12/23
 */
public class MergeArrayDisplay {
    /**
     * 数组是可以是由一个大数组拆分成2个小数组
     * 所以我们不要拘泥于数组的表示方式
     */
    @Test
    public void testSplitArray() {
        int[] total = {1, 2, 5, 1, 8, 90, 30, 80, 10, 70};
        int low = 0;
        int high = total.length - 1;

        // 数组计算中间位置
        int mid = (low + high) / 2;
        // 动态数组另一种计算数组大小的方式
        int totalLength = high - low + 1;
        System.out.println("low array and hight array total length = " + totalLength);
        System.out.println("low array startIndex = " + low + " end index = " + mid);
        System.out.println("array in low array");
        for (int i = low; i <= mid; i++) {
            System.out.print(total[i] + ",");
        }
        System.out.println();
        System.out.println("high array startIndex = " + (mid + 1) + " end index = " + high);
        System.out.println("array in high array");
        for (int i = mid + 1; i <= high; i++) {
            System.out.print(total[i] + ",");
        }
        System.out.println();
    }


    /**
     * 实战 合并所有
     */
    @Test
    public void testMergeTotal() {
        int[] total = {1, 2, 4, 6, 8, 1, 3, 7, 10, 70};
        int low = 0;
        int high = total.length - 1;
        int mid = (low + high) / 2;
        int[] result = merge(total, low, mid, high);
        System.out.println("arrays = " + Arrays.toString(result));
    }

    /**
     * 实战 合并部分
     */
    @Test
    public void testMergePart() {
        int[] total = {1, 1, 3, 8, 4, 7, 1,1};
        int low = 2;
        int high = 5;
        int mid = (low + high) / 2;
        int[] result = merge(total, low, mid, high);
        System.out.println("arrays = " + Arrays.toString(result));
    }

    private int[] merge(int[] total, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= high) {
            if (total[i] < total[j]) {
                temp[tempIndex++] = total[i++];
            } else {
                temp[tempIndex++] = total[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = total[i++];
        }
        while (j <= high) {
            temp[tempIndex++] = total[j++];
        }
        return temp;
    }
}
