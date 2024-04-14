package com.javaapi.test.util.math.algorithm.sort.swap.quick;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2018/11/29
 * 快排-交换法
 */
public class QuickSort2 {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, pivot, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        pivot = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        System.out.println("i = " + i + "    j=" + j + "  pivot=" + pivot + "  arr[i或j]=" + arr[i] + "   pivot>=arr[i或j]?" + (pivot >= arr[i]) + "  low=" + low);
        arr[low] = arr[i];
        arr[i] = pivot;

        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 个数为偶数
     */
    @Test
    public void test2() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

}
