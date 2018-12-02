package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

import java.util.Arrays;

/**
 *  快速排序第四课
 */
public class ScanAndSwitch {

    /**
     * 如果扫描到相关值,则进行替换
     * 比中值(数组第一个小),所以将35 移动到第左面第一个
     */
    @Test
    public void testRight(){
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimit(a,9,0 ,a[0]);
        System.out.println("a = " + Arrays.toString(a));
    }

    @Test
    public void testRightLeft(){
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("a = " + Arrays.toString(a));
    }

    @Test
    public void testRight1(){
        int[] a = {90, 0 ,50, 20, 30,40,50,35,70,91};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("a = " + Arrays.toString(a));
    }



    private void scanScopeWithBothLimit(int[] a, int right, int left , int pivot) {
        // 这里pivot取数组第一个元素
        while (a[right] >= pivot && right>left) {
            right--;
        }
        System.out.println("index=" + right + "  value=" + a[right]);


        if (right > left) {
            a[left] = a[right];
            ++left;
        }
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
        System.out.println("left after = " + Arrays.toString(a));

    }

}
