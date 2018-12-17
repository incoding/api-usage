package com.javaapi.test.util.math.algorithm.sort.heapsort.lession.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * 构建大堆顶
 */
@Slf4j
public class HeapSortLession2 {
    private int arr[] = {4, 5, 2, 1, 8, 10, 2};

    @Test
    public void buildMaxHeap() {
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        for (int i = (arr.length / 2) - 1; i >=0 ; i--) {
            buildHeap(arr, i, arr.length);
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static void buildHeap(int[] arr, int start, int length) {
        int left = 2 * start + 1;
        int right = left + 1;
        int maxIndex = getMaxIndex(arr,start, length, left, right);

        if (maxIndex == start) {
            return;
        }
        swap(arr,start,maxIndex);
        buildHeap(arr, maxIndex, length);
    }


    private static int getMaxIndex(int[] arr, int start, int length,int left, int right) {
        int tempStartIndex = start;
        if (left<length && arr[tempStartIndex] < arr[left]) {
            tempStartIndex = left;
        }
        if (right<length && arr[left] < arr[right]) {
            tempStartIndex = right;
        }
        return tempStartIndex;
    }

//    /**
//     * 选比较left和idx
//     * 如果有right则再进行比较 ( left和idx 中的值最大数对应的index)
//     * @param array
//     * @param idx
//     * @param max
//     * @param left
//     * @param right
//     * @return
//     */
//    private static int getMaxIndex(int[] array, int idx, int max, int left, int right) {
//        int largest;
//        if (left <= max-1 && array[left] > array[idx]) {
//            largest = left;
//        } else {
//            largest = idx;
//        }
//
//        if (right <= max-1 && array[right] > array[largest]) {
//            largest = right;
//        }
//        return largest;
//    }

    public static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
