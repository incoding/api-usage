package com.javaapi.test.util.math.algorithm.sort.heapsort.lession.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * 构建大堆顶
 */
@Slf4j
public class HeapSortLession3 {

    @Test
    public void heapSort() {
        int[] arr = new int[]{4, 5, 2, 1, 8, 10, 2};
        int length = arr.length;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        heapSort(arr, length);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 注意处理最大值的逻辑, 默认取当前节点为最大值, 如果有左子树就判断左子树,如果有右子树就判断右子树
     */
    @Test
    public void heapSort2() {
//        int[] arr = new int[]{7,5};
        int[] arr = new int[]{7};
        int length = arr.length;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        heapSort(arr, length);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private void heapSort(int[] arr, int length) {
        buildMaxHeap(arr, length);
        for (int i = length - 1; i > 0; i--) {
            HeapSortLession2.swap(arr, i, 0);
            HeapSortLession2.buildHeap(arr, 0, i);
        }
    }

    public void buildMaxHeap(int[] arr, int length) {
        for (int i = (length / 2) - 1; i >= 0; i--) {
            HeapSortLession2.buildHeap(arr, i, length);
        }
    }


}
