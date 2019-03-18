package com.javaapi.test.util.math.algorithm.select.binary;

import org.junit.Test;
import org.testng.Assert;

/**
 * Created by user on 2019/1/6
 */
public class Client {


    @Test
    public void testRecursionBinarySearchFirst() {
        int expect = 0;
        int[] arr = {2, 5, 9, 10, 20};
        int key = arr[expect];
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
        Assert.assertEquals(i, expect);
    }

    @Test
    public void testRecursionBinarySearchMiddle() {
        int expect = 3;
        int[] arr = {2, 5, 9, 10, 20};
        int key = arr[expect];
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
        Assert.assertEquals(i, expect);
    }

    @Test
    public void testRecursionBinarySearchEnd() {
        int expect = 4;
        int[] arr = {2, 5, 9, 10, 20};
        int key = arr[expect];
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
        Assert.assertEquals(i, expect);
    }


    @Test
    public void testRecursionBinarySearchNone() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 7;
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
        Assert.assertEquals(i, -1);
    }
}
