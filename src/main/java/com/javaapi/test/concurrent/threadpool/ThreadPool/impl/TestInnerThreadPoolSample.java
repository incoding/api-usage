package com.javaapi.test.concurrent.threadpool.ThreadPool.impl;

import org.junit.Test;

/**
 *
 */
public class TestInnerThreadPoolSample {


    /**
     * 1 如何获得指定数量x的 二进制1
     * 答  将指定数量x 左移1位 并减去1,
     *
     */
    @Test
    public void testCtl() {
        int size = 5;
        int binary = (1 << size) - 1;
        System.out.println("binary = " + Integer.toBinaryString(binary));
    }

}
