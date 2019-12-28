package com.javaapi.test.util.math.algorithm.sort.merge.lession0;

import org.junit.Test;

import java.util.Arrays;


/**
 * 这里演示下数组拆分
 */
public class SplitArray {
    /**
     * 大数组以二分的方式圈出小数组(小数组中元素至少1个元素),
     * 记得考虑 数组是奇数个和偶数个的情况
     */
    @Test
    public void test() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        split2(a, 0, a.length - 1);
    }

    /**
     * 第一种退出限制
     *
     * @param a
     * @param low
     * @param high
     */
    private void split1(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (mid < low || mid > high) {
            return;
        }
        // 只剩下一个元素的时候,就不需要继续拆分了
        if (low == high) {
            int[] subArray = getSubArray(a, low, high);
            System.out.println("子数组为" + Arrays.toString(subArray));
            return;
        }
        split1(a, low, mid);

        split1(a, mid + 1, high);
    }

    /**
     * 第二种退出限制
     *
     * @param a
     * @param low
     * @param high
     */
    private void split2(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            split2(a, low, mid);

            split2(a, mid + 1, high);
        } else {
            int[] subArray = getSubArray(a, low, high);
            System.out.println("子数组为" + Arrays.toString(subArray));
        }
    }

    /**
     * 获取子数组
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int[] getSubArray(int[] a, int low, int high) {
        // 这里high+1 是因为Arrays.copyOfRange 是左闭右开, 所以需要high+1,才能把右侧闭合
        return Arrays.copyOfRange(a, low, high + 1);
    }

    @Test
    public void copyRange() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0};
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, 2)));
    }
}
