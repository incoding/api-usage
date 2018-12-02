package com.javaapi.test.util.math.algorithm.sort.base;

import org.junit.Test;

import java.util.Arrays;

/**
 *  快速排序第六课
 *  一轮完整的遍历
 */
public class ScanAndSwapArrInWhile {


    @Test
    public void testRight1(){
        int[] a = {60,40,10,90,70,80,0 ,50, 20, 30};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }

    /**
     * 只有一侧有替换,只有右侧有替换
     */
    @Test
    public void testRightOneSwap(){
        int[] a = {40,40,40,40,40,40,40,40, 20, 50};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }

    /**
     * 只有一侧有替换,只有右侧有替换
     */
    @Test
    public void testBoth(){
        int[] a = {40,50,40,40,40,40,40,40, 20, 50};
        System.out.println("a = " + Arrays.toString(a));
        scanScopeWithBothLimitBothSide(a,9,0 ,a[0]);
        System.out.println("final arr is  = " + Arrays.toString(a));
    }



    private void scanScopeWithBothLimitBothSide(int[] a, int right, int left , int pivot) {
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
            System.out.println("left arr after is  = " + Arrays.toString(a));
        }
        System.out.println("-----------------");

        System.out.println("last left =" +left+" right= "+right);
        a[left] = pivot;
    }

}
