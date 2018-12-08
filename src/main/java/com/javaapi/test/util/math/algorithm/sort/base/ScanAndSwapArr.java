package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

import java.util.Arrays;

/**
 *  快速排序第四课 扫描和交换 2
 */
public class ScanAndSwapArr {


    @Test
    public void testRight1(){
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("a = " + Arrays.toString(a));
    }



    private void scanScopeWithBothLimitBothSide(int[] a, int right, int left , int pivot) {
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
        System.out.println("left after is = " + Arrays.toString(a));



    }

}
