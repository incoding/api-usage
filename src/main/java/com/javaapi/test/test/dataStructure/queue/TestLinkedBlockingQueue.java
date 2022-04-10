package com.javaapi.test.test.dataStructure.queue;


import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * for arraylist
 */
public class TestLinkedBlockingQueue {

    @Test
    public void testBlockingQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println("添加完毕");
    }
}
