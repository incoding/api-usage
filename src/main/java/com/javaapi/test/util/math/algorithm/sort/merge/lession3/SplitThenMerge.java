package com.javaapi.test.util.math.algorithm.sort.merge.lession3;

import com.javaapi.test.util.math.algorithm.sort.merge.lession2.ReplaceArray;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1 一个大数组拆分成2个有序子数组(子数组元素至少一个),
 * 2 然后合并成一个有序大数组,有序大数组要写回原大数组
 */
public class SplitThenMerge {

    @Test
    public void testSplit() {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("a = " + Arrays.toString(a));
    }

    private void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            ReplaceArray.merge(a, low, mid, high);
        }

    }

}
