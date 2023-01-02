package com.javaapi.test.util.math.algorithm.select.binary;

/**
 * Created by user on 2019/1/6
 */
public class CommonBinarySearch2 {

    public static int binarySearch(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < left || mid > mid) {
                return -1;
            }
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
