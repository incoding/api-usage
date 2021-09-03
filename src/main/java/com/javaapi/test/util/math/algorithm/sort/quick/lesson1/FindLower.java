package com.javaapi.test.util.math.algorithm.sort.quick.lesson1;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by user on 2019/12/29
 */
public class FindLower {
    /**
     * 从左向右
     * 找到比某个值大的索引,并输出索引值
     */
    @Test
    public void testFindLower() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        int i = 0;
        int privot = 5;
        while (a[i] < privot) {
            i++;
        }
        System.out.println("i = " + i);
    }

    /**
     * 从右向左
     * 找到比某个值小的索引,并输出索引值
     */
    @Test
    public void testFindHigher() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        int i = a.length - 1;
        int privot = 5;
        while (a[i] > privot) {
            i--;
        }
        System.out.println("i = " + i);
    }

    /**
     * 从右向左查找比某个值小，从左向右查找比某个值大
     */
    @Test
    public void testFindLowerHighter() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        int i = 0;
        int j = a.length - 1;
        int privot = 5;
        while (a[i] < privot) {
            i++;
        }
        while (a[j] > privot) {
            j--;
        }
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    /**
     * 同时发现比某值大并且比某值小,然后调换位置
     */
    @Test
    public void testFindLowerHighterAndReplace() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        System.out.println("初始" + Arrays.toString(a));

        int i = 0;
        int j = a.length - 1;
        int privot = 5;
        while (a[i] < privot) {
            i++;
        }
        while (a[j] > privot) {
            j--;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        System.out.println("结果为" + Arrays.toString(a));
    }

    /**
     * 从2边同时缩进
     * 同时发现比某值大并且比某值小,然后调换位置
     *
     * 注意 i 和j 范围,  就是左界限一直小小于等于右侧界限
     */
    @Test
    public void testFindLowerHighterAndReplaceMultipleTimes() {
        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};
        int i = 0;
        int j = a.length - 1;
        int privot = 9;
        while (i <= j) {
            while (a[i] < privot && i <= j) {
                i++;
            }
            while (a[j] > privot && i <= j) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                System.out.println("i = " + i + " j=" + j + " 结果为" + Arrays.toString(a));

                i++;
                j--;
            }
        }
        System.out.println("i = " + i + " j=" + j + " 结果为" + Arrays.toString(a));

    }

    /**
     * 从2边同时缩进
     * 同时发现比某值大并且比某值小,然后调换位置
     */
    @Test
    public void testQuickSort() {

        int[] a = {9, 2, 3, 8, 6, 5, 7, 1, 4, 0, 11};

        quickSort(a, 0, a.length - 1);
        System.out.println("结果" + Arrays.toString(a));
    }

    public void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
//        int privot = a[(low + high) / 2];
        int privot = a[low];
        String tempArr = Arrays.toString(Arrays.copyOfRange(a, low, high + 1));
        while (i <= j) {
            while (a[j] > privot && i <= j) {
                j--;
            }
            while (a[i] < privot && i <= j) {
                i++;
            }
            // 此时要处理遍历完整个数组位置的情况
            if (i < j) {
                // 情况一
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            } else if (i == j) {
                //情况二 i ==j的时候,无需交换,但是此时为了接下来分配子数组不产生冲突,需要将i+1
                i++;
                System.out.println("-----数组" + tempArr + "low=" + low + "high" + high + " 基准值" + privot + " 交换后" + Arrays.toString(Arrays.copyOfRange(a, low, high + 1)));

            }
        }
        System.out.println("数组" + tempArr + "low=" + low + "high" + high + " 基准值" + privot + " 交换后" + Arrays.toString(Arrays.copyOfRange(a, low, high + 1)));
        quickSort(a, low, j);
        quickSort(a, i, high);

    }


}
