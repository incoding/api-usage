package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

import java.util.Arrays;

/**
 *  快速排序第六课
 *  一轮完整的遍历
 */
public class ScanAndSwapArrInWhileWithRecursion {

    /**
     * 只有一侧有替换,只有右侧有替换
     */
    @Test
    public void testBoth(){
        int[] a = {40,50,40,40,40,40,40,40, 20, 50};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a, 0, a.length-1);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }

    /**
     * 递归到最后 ,不设置终结条件会出问题
     */
    @Test
    public void testQuickSortWithOutFinish() {
        int[] a = {40,50,40,40,40,40,40,40, 20, 50};
        System.out.println("a = " + Arrays.toString(a));
        quickSortWithOutFinish(a, 0, a.length-1);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }

    @Test
    public void testQuickSort() {
        int[] a = {40,50,40,40,40,40,40,40, 20, 50};
        System.out.println("a = " + Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }

    /**
     * 包装得更易用,增加判空
     */
    @Test
    public void testQuickSort2() {
        int[] a = {40};
        System.out.println("a = " + Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }


    public void quickSortWithOutFinish(int[] a, int left, int right) {
        int mid = scanScopeWithBothLimitBothSide(a, left, right);
        quickSort(a,left,mid);
        quickSort(a,mid+1,right);
    }



    public void quickSort(int[] a, int left, int right) {
        if (a == null ||right <= left) {
            return;
        }

        int mid = scanScopeWithBothLimitBothSide(a, left, right);
        quickSort(a,left,mid);
        quickSort(a,mid+1,right);
    }



    private int scanScopeWithBothLimitBothSide(int[] a, int left, int right) {
        int pivot = a[left];
        while (right > left) {
            // 这里pivot取数组第一个元素
            while (a[right] >= pivot && right>left) {
                right--;
            }
            System.out.println("right index=" + right + "  value=" + a[right]);

            System.out.println("right before = " + Arrays.toString(a));

            if (right > left) {
                a[left] = a[right];
                ++left;
                System.out.println("a = " + Arrays.toString(a));
            }
            System.out.println("right  after = " + Arrays.toString(a));

            while (a[left] <= pivot && right > left) {
                ++left;
            }
            System.out.println("left index=" + left + "  value=" + a[left]);
            System.out.println("left before = " + Arrays.toString(a));

            if (right > left) {
                a[right] = a[left];
                --right;
            }
            System.out.println("recursion left arr after is  = " + Arrays.toString(a));
        }
        System.out.println("-----------------");

        System.out.println("last left =" +left+" right= "+right);
        a[left] = pivot;
        return left;
    }

}
