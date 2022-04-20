package com.javaapi.test.test.dataStructure.queue;


import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * for arraylist
 * 底层是数组实现
 */
public class TestArrayBlockingQueue {

    @Test
    public void testBlockingQueue() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println("添加完毕");
    }
}
