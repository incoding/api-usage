package com.javaapi.test.util.math.algorithm.sort.merge.lession2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @see ArrayDisplay  部分我们合并部分数组并返回合并的数组
 * 这节我们将合并后的数组替换到原数组当中
 */
public class ArrayReplace {



    /**
     *实战 合并后放入原数组
     */
    @Test
    public void testMergePartAndReplace() {
        int[] total = {1, 1, 3, 8, 4, 7, 1,1};
        int low = 2;
        int high = 5;
        int mid = (low + high) / 2;
        merge(total, low, mid, high);
        System.out.println("arrays = " + Arrays.toString(total));
    }

    public static void merge(int[] total, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= high) {
            if (total[i] < total[j]) {
                temp[tempIndex++] = total[i++];
            }else{
                temp[tempIndex++] = total[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = total[i++];
        }
        while (j <= high) {
            temp[tempIndex++] = total[j++];
        }

        tempIndex = 0;
        for (int k = low;k<low+temp.length;k++) {
            total[k] = temp[tempIndex++];
        }
    }
}
