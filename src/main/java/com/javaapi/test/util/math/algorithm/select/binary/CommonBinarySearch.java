package com.javaapi.test.util.math.algorithm.select.binary;

/**
 * Created by user on 2019/1/6
 */
public class CommonBinarySearch {
//    /**
//     * refer https://blog.csdn.net/maoyuanming0806/article/details/78176957
//     */
//    public static int commonBinarySearch(int[] arr,int key){
//        int low = 0;
//        int high = arr.length - 1;
//        //定义middle
//        int middle = 0;
//
//        if(key < arr[low] || key > arr[high] || low > high){
//            return -1;
//        }
//        while(low <= high){
//            middle = (low + high) / 2;
//            if(arr[middle] > key){
//                //比关键字大则关键字在左区域
//                high = middle - 1;
//            }else if(arr[middle] < key){
//                //比关键字小则关键字在右区域
//                low = middle + 1;
//            }else{
//                return middle;
//            }
//        }
//        //最后仍然没有找到，则返回-1
//        return -1;
//    }

    /**
     * kk self
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearchV2(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid<low || mid > high){
                return -1;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else if (key == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }
}
