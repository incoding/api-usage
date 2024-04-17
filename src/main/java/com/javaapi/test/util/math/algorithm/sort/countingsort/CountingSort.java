package com.javaapi.test.util.math.algorithm.sort.countingsort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    @Test
    public void sortArray() {
        int[] a = {2, 3, 1, 9, 5, 6, 6, 6, 6};
        int[] result = new CountingSort().sortArray(a);
        System.out.println("temp = " + Arrays.toString(result));

    }

    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 获取最大最小值
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        // 计数数组
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        // 遍历计数数组进行恢复,恢复后默认是排序的
        System.out.println("temp = " + Arrays.toString(counts));
        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counts[num - min] > 0) {
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
    }
}
