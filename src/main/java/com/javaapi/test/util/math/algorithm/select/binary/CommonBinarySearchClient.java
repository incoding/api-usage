package com.javaapi.test.util.math.algorithm.select.binary;

import org.junit.Test;

/**
 * Created by user on 2019/1/6
 */
public class CommonBinarySearchClient {

    @Test
    public void testRecursionBinarySearchFirst() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 2;
        int i = CommonBinarySearch.commonBinarySearchV2(arr, key);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchMiddle() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 10;
        int i = CommonBinarySearch.commonBinarySearchV2(arr, key);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchEnd() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 20;
        int i = CommonBinarySearch.commonBinarySearchV2(arr, key);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchNone() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 7;
        int i = CommonBinarySearch.commonBinarySearchV2(arr, key);
        System.out.println("i = " + i);
    }
}
