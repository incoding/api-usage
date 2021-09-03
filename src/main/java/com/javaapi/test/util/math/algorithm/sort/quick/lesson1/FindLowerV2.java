package com.javaapi.test.util.math.algorithm.sort.quick.lesson1;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by user on 2019/12/29
 */
public class FindLowerV2 {


    /**
     * 如果基准值选取的是左侧第一个,一般都是从右向左
     * 从右向左
     * 找到比某个值小的索引,并输出索引值
     */
    @Test
    public void testFindHigher() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        int i = 0;
        int j = a.length - 1;
        int privot = a[i];
        while (a[j] > privot) {
            j--;
        }
        a[i] = a[j];
        System.out.println("j = " + Arrays.toString(a));
    }

    /**
     * 1 基准值暂存
     * 2 从右向左找比基准值小的, 找到后将值放到基准值位置, 并且将左侧位置+1
     * 3 从左向右找比基准值大的, 找到后将值放到2的位置，并且将右侧位置-1
     */
    @Test
    public void testFindHigherAndLower() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11, 5};
        int i = 0;
        int j = a.length - 1;
        int privot = a[i];
        while (a[j] > privot && i < j) {
            j--;
        }
        if (i < j) {
            a[i] = a[j];
        }

        while (a[i] < privot && i < j) {
            i++;
        }
        if (i < j) {
            a[j] = a[i];
        }
        a[i] = privot;
        System.out.println("j = " + Arrays.toString(a));
    }


    /**
     * 进行一次遍历，整理小于基准值,在基准值左侧，大于基准值在基准值右侧
     * 1 基准值暂存
     * 2 从右向左找比基准值小的, 找到后将值放到基准值位置, 并且将左侧位置+1
     * 3 从左向右找比基准值大的, 找到后将值放到2的位置，并且将右侧位置-1
     * 4 重复上面2，3步骤. 直到i=j
     * 5 将基准值回填到i
     */
    @Test
    public void testWhile() {
        int[] a = {5, 2, 3, 8, 6, 9, 7, 1, 4, 0, 11};
        int i = 0;
        int j = a.length - 1;
        int privot = a[i];
        while (i < j) {
            while (a[j] > privot && i < j) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
            }

            while (a[i] < privot && i < j) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
            }
        }
        a[i] = privot;
        System.out.println("j = " + Arrays.toString(a));
    }


    /**
     * 进行一次遍历，整理小于基准值,在基准值左侧，大于基准值在基准值右侧
     */
    @Test
    public void testPartition() {
        int[] a = {5, 2, 3, 8, 6, 9, 7, 1, 4, 0, 11, 5};
        partition(a, 0, a.length - 1);
        System.out.println("result = " + Arrays.toString(a));
    }

    private int partition(int[] a, int low, int tail) {
        int i = low;
        int j = tail;
        int privot = a[i];
        while (i < j) {
            while (a[j] > privot && i < j) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (a[i] < privot && i < j) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = privot;
        System.out.println("j = " + Arrays.toString(a));
        return i;

    }


    /**
     *
     */
    @Test
    public void testSort() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11, 5};
        new FindLowerV2().quickSort(a, 0, a.length - 1);
        System.out.println("result = " + Arrays.toString(a));

    }

    public void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = partition(a, low, high);
        quickSort(a, low, mid - 1);
        quickSort(a, mid + 1, high);
    }

}
