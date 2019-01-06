package com.javaapi.test.util.math.algorithm.select.binary;

import org.junit.Test;

/**
 * Created by user on 2019/1/6
 */
public class Client {


    @Test
    public void testRecursionBinarySearchFirst() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 2;
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchMiddle() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 10;
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchEnd() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 20;
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
    }
    @Test
    public void testRecursionBinarySearchNone() {
        int[] arr = {2, 5, 9, 10, 20};
        int key = 7;
        RecursionBinarySearch recursionBinarySearch = new RecursionBinarySearch();
        int i = recursionBinarySearch.recursionBinarySearch(arr, key, 0, arr.length - 1);
        System.out.println("i = " + i);
    }
}
