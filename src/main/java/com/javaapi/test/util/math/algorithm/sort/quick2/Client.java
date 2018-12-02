package com.javaapi.test.util.math.algorithm.sort.quick2;

import org.junit.Test;

/**
 * Created by user on 2018/12/2
 */
public class Client {
    @Test
    public void test(){
        int[] arr = {1,2,1,1,1,1,1,1,1,1};
        Test09.quickSort(arr, 0, arr.length - 1);
        Test09.printArr(arr);
    }
}
