package com.javaapi.test.util.math.algorithm.sort.quick3;

/**
 * refer
 * https://blog.csdn.net/MoreWindows/article/details/6684558
 */
public class QuickSort {
    //快速排序
    static void quick_sort(int arr[], int left, int right)
    {
        if (left < right)
        {
            //Swap(arr[left], arr[(left + right) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right, x = arr[left];
            while (i < j)
            {
                // 从右向左找第一个小于x的数
                while (i < j && arr[j] >= x) {
                    j--;
                }

                if (i < j) {
                    arr[i++] = arr[j];
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && arr[i] < x) {
                    i++;
                }

                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            // 递归调用
            quick_sort(arr, left, i - 1);
            quick_sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {72,6,57,88,60,42,83,73,48,85};
        quick_sort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }
}
