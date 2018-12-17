package com.javaapi.test.util.math.algorithm.sort.lession;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 变量求最大值
 * 2个变量求最大值 这个不用说了
 * 3个变量求最大值
 * N个变量求最大值
 */
@Slf4j
public class CompareVar {

    /**
     * 3个变量求最大值
     */
    @Test
    public void testGetMax() {
        int a = 10;
        int b = 30;
        int c = 20;
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("max = " + max);
    }

    /**
     * 数组中3个变量求最大值所在的index
     */
    @Test
    public void testGetMaxFromArr() {
        int[] arr = {10, 30, 35};
        // 当前节点 索引
        int currentIndex = 0;
        int left = 1;
        int right = left + 1;
        int maxIndex = getMaxIndex(arr, currentIndex, left, right);
        System.out.println("maxIndex = " + maxIndex);
    }

    private int getMaxIndex(int[] arr, int start, int left, int right) {
        int tempMaxIndex = left;

        if (arr[left] < arr[right]) {
            tempMaxIndex = right;
        }
        if (arr[tempMaxIndex] < arr[start]) {
            tempMaxIndex = start;
        }
        log.info("最大值 index={},value={}", tempMaxIndex, arr[tempMaxIndex]);
        return tempMaxIndex;
    }

    @Test
    public void testMax() {
        //定义一维数组
        int[] myList = {2, 3, 4, 5, 10, 11, 15, 100, -1, -4};
        //0为第一个数组下标
        int num = myList[0];
        //开始循环一维数组
        for (int i = 0; i < myList.length; i++) {
            //循环判断数组元素
            if (myList[i] > num) {
                //赋值给num，然后再次循环
                num = myList[i];
            }
        }
        //跳出循环，输出结果
        System.out.println("最大值为" + num);
    }
}


