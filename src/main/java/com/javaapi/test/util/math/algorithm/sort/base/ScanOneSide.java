package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

/**
 * 快速排序第二课
 * Created by user on 2018/11/30
 */
public class ScanOneSide {



    @Test
    public void testScanAllWayOne() {

        int[] a = {12, 3, 4, 56, 2, 1, 89, 28};
        scanAllWayOne(a,a[0]);
    }

    @Test
    public void testScanAllWayTwo() {
        int[] a = {12, 3, 4, 56, 2, 1, 89, 28};
        scanAllWayTwo(a,a[0]);
    }

    /**
     * 扫描数字 ,右边界 可配置, 右边界传入数组最大值
     */
    @Test
    public void testScanWithRightSide() {
        int[] a = {12, 3, 4, 56, 2, 1, 89, 28};
        scanScopeWithRightSide(a, a.length - 1,a[0]);
    }

    /**
     * 扫描数字 ,右边界 可配置,   右边界传入随机一个位置
     */
    @Test
    public void testScanWithRightSide2() {
        int[] a = {12, 3, 4, 56, 2, 1, 89, 28};
        scanScopeWithRightSide(a, 3,a[0]);
    }

    /**
     * 扫描数字 ,右边界 可配置, 注意右边界不要超过左边界
     */
    @Test
    public void scanScopeWithRightSideLimit() {
        int[] a = {12, 3, 4, 56, 2, 1, 89, 28};
        scanScopeWithRightSide(a, a.length - 1,a[0]);
    }



    private void scanAllWayTwo(int[] a, int num) {
        int index = a.length-1;
        while (a[index] >= num && index>=0) {
            index--;
        }

        System.out.println("index="+index+"value="+a[index]);
    }

    private void scanAllWayOne(int[] a, int num) {
        int index = 0;
        for (int i = a.length-1; i>0 ; i--) {
            if (a[i] >= num) {
                continue;
            }
            index = i;
            break;

        }
        System.out.println("wayOne");
        System.out.println("index="+index+"value="+a[index]);
    }



    private void scanScopeWithRightSide(int[] a, int index, int pivot) {
        // 这里pivot取数组第一个元素
        while (a[index] >= pivot && index>0) {
            index--;
        }
        System.out.println("index=" + index + "value=" + a[index]);
    }



}
