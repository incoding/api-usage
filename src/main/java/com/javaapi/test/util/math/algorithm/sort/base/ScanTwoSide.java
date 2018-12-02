package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

/**
 * 快速排序第三课
 */
public class ScanTwoSide {

    /**
     * 扫描数字 ,右边界 可配置, 注意右边界不要超过左边界
     */
    @Test
    public void scanScopeWithBothSideLimit() {
        int[] a = {12, 10, 20, 30, 40, 1, 89, 28};
        scanScopeWithBothLimit(a,4,2 ,a[0]);
    }


    /**
     * 扫描数字 ,右边界 可配置, 注意右边界不要超过左边界
     */
    @Test
    public void scanScopeWithBothScan() {
        int[] a = {40, 0 ,50, 20, 30,40,50,35,70,80};
        scanScopeWithBothScan(a,9,1 ,a[0]);
    }

    private void scanScopeWithBothLimit(int[] a, int right, int left , int pivot) {
        // 这里pivot取数组第一个元素
        while (a[right] >= pivot && right>left) {
            right--;
        }
        System.out.println("index=" + right + "value=" + a[right]);
    }

    /**
     * left  根据x 轴,从左向右
     * right 根据x 轴,从右向左
     * @param a
     * @param right
     * @param left
     * @param pivot
     */
    private void scanScopeWithBothScan(int[] a, int right, int left , int pivot) {
        // 这里pivot取数组第一个元素
        while (a[right] >= pivot && right>left) {
            right--;
        }
        System.out.println("right index=" + right + "value=" + a[right]);


        while (a[left] < pivot && right>left) {
            left++;
        }
        System.out.println("left index=" + left + "value=" + a[left]);

    }
}
