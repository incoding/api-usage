package com.javaapi.test.util.math.algorithm.sort.merge.lesson2;

import com.javaapi.test.util.math.algorithm.sort.merge.lesson1.MergeArrayDisplay;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see MergeArrayDisplay  部分我们合并部分数组并返回合并的数组
 * 这节我们将合并后的数组替换到原数组当中
 */
public class ReplaceArray {


    /**
     * 实战 合并后的临时数组,放入原数组指定位置
     */
    @Test
    public void testTempToOrigin() {
        int[] total = {1, 1, 3, 8, 4, 7, 1, 2};
        int low = 2;
        int mid = 3;
        int high = 4;
        putTemp(total, low, mid, high);
        System.out.println("temp = " + Arrays.toString(total));


    }

    public void putTemp(int[] total, int low, int mid, int high) {

        int[] temp = {1, 2, 3};
        int tempIndex = 0;
        for (int i = low; i < low + temp.length; i++) {
            total[i] = temp[tempIndex++];
        }

    }


    /**
     * 1 通过 low 和mid , mid+1 和high 圈定俩个数组
     * 2 俩个数组依次比较，获取小值放入临时数组,直到俩个数组有中有一个遍历完毕
     * 3 剩下一个数组数据放入临时数组
     */
    @Test
    public void testMergePartAndReplace() {
        int[] total = {1, 1, 3, 8, 4, 7, 1, 1};
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

        tempIndex = 0;
        for (int k = low; k < low + temp.length; k++) {
            total[k] = temp[tempIndex++];
        }
    }
}
