package com.javaapi.test.util.math.algorithm.select.binary;

/**
 * Created by user on 2019/1/6
 */
public class RecursionBinarySearch {
    /**
     * kk 编写
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public int recursionBinarySearch(int[] arr, int key,int low,int high) {
        int middle = (high + low) / 2;
        if (middle<low || middle>high){
            return -1;
        }

        if (key == arr[middle]) {
            return middle;
        }

        if (key > arr[middle]) {
            return recursionBinarySearch(arr, key,middle+1,high);
        } else if (key < arr[middle]) {
            return recursionBinarySearch(arr, key,low,middle-1);
        }
        return -1;
    }

    /**
     * refer https://blog.csdn.net/maoyuanming0806/article/details/78176957
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public int recursionBinarySearchV2(int[] arr, int key,int low,int high) {
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        //初始中间位置
        int middle = (low + high) / 2;
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }
    }
}
