package com.javaapi.test.util.math.algorithm.sort.bubble;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *
 * arr.length-1 操作 是为了避免在遍历时候 当前索引与下一个索引比较,导致下一个索引超过下标
 *
 */
@Slf4j
public class BubbleSort3_1 {


    /**
     * 数组当前索引与索引+1 比较
     */
    @Test
    public void testIndex1() {
        int[] arr = {6, 7, 8, 2, 9, 3};

        for (int i = 0; i < arr.length - 1; i++) {
            log.info("a[i]={},a[i+1]={}", arr[i], arr[i + 1]);
        }
    }

    /**
     * 数组当前索引与索引+2 比较
     */
    @Test
    public void testIndex2() {
        int[] arr = {6, 7, 8, 2, 9, 3};

        for (int i = 0; i < arr.length - 2; i++) {
            log.info("a[i]={},a[i+1]={}", arr[i], arr[i + 2]);
        }
    }


    /**
     * 数组当前索引与索引+N 比较
     *
     * 这个 索引N 将可遍历的数据圈定了一个范围,  保护数组不越界
     */
    @Test
    public void testIndexN() {
        int[] arr = {6, 7, 8, 2, 9, 3};

        int indexInc = 4;

        for (int i = 0; i < arr.length - indexInc; i++) {
            log.info("a[i]={},a[i+1]={}", arr[i], arr[i + indexInc]);
        }
    }

}
