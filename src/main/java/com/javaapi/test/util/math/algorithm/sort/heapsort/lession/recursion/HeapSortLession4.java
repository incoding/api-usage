package com.javaapi.test.util.math.algorithm.sort.heapsort.lession.recursion;

import org.junit.Test;

import java.util.Arrays;


/**
 * 构建大堆顶,速通
 */
public class HeapSortLession4 {

    @Test
    public void test(){
        int[] a = {1, 5, 3, 4, 9, 6, 7, 8, 9, 10};

        System.out.println("a = " + Arrays.toString(a));
        buildMaxHeap(a,a.length);
        System.out.println("a = " + Arrays.toString(a));
    }

    private void buildMaxHeap(int[] a, int length) {
        for (int i=a.length/2-1;i>=0;i--) {
            buildHeap(a, i, length);
        }
        for(int i=length-1;i>0;i--) {
            swap(a, i, 0);
            buildHeap(a,0,i);
        }

    }

    private void buildHeap(int[] a, int i, int length) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largestIndex = getLargestIndex(a, i, length, left, right);
        if (largestIndex != i) {
            swap(a, i, largestIndex);
            buildHeap(a,largestIndex,length);
        }
    }

    private void swap(int[] a, int i, int largestIndex) {
        int temp = a[i];
        a[i] = a[largestIndex];
        a[largestIndex] = temp;
    }

    private int getLargestIndex(int[] a, int i, int length, int left, int right) {
        int largestIndex = i;
        if (left<length && a[largestIndex] < a[left]) {
            largestIndex = left;
        }
        if (right<length && a[largestIndex] < a[right]) {
            largestIndex = right;
        }
        return largestIndex;
    }


}
