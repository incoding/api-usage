package com.javaapi.test.concurrent.block;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 设置合适得任务队列长队
 * 1 阻塞队列是为了容纳或排序多线程任务而存在的
 * 2 阻塞队列必须设置长度
 * 内部实现为lock+(await,singal模型,kk 自己理解的,queue倆端有倆个事件,所以说就又notEmpty,和notFull倆个事件)
 * 1 先上锁,然后判断
 */
public class TestArrayBlockQueue {
    /**
     * add  插入不成功则扔异常, 内部实现为判断offer得返回值
     */
    @Test
    public void testAdd() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            queue.add("");
        }
        System.out.println("queue size = " + queue.size());
    }

    /**
     * remove 与add 相对会扔出异常
     */
    @Test
    public void testRemove() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 5; i++) {
            queue.add("");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            queue.remove();
        }
    }


    /**
     * offer 插入不成功则返回false
     */
    @Test
    public void testOffer() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 10; i++) {
            boolean offer = queue.offer("");
            System.out.println(i + " = " + offer);
        }
        System.out.println("queue size = " + queue.size());
    }

    /**
     * poll 与offer相对,如果不能拿出则返回null
     */
    @Test
    public void testPoll() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 5; i++) {
            queue.offer("");
        }
        for (int i = 0; i < 10; i++) {
            String poll = queue.poll();
            System.out.println("i = " + poll);
        }
    }

    /**
     * put 永久阻塞直到插入成功,注意put方法会扔出受检异常需要处理好
     */
    @Test
    public void testPut() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            try {
                queue.put("");
                System.out.println("capacity = " + queue.remainingCapacity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("queue size = " + queue.size());
    }

    /**
     * take与poll相对,取不出数据会阻塞
     */
    @Test
    public void testTake() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 5; i++) {
            try {
                queue.put("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            String poll = null;
            try {
                poll = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i = " + poll);
        }
    }

    /**
     * 1  长期不能插入队列,并且多个线程长期不能插入队列,那么肯定会持续占用资源
     * 2  为了处理这种情况需要使用带超时时间的offer方法,超过一定时间不能放入则
     */
    @Test
    public void testOfferTimeOut() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 10; i++) {
            Boolean offer = null;
            try {
                offer = queue.offer("", 5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " = " + offer);
        }
        System.out.println("queue size = " + queue.size());
    }

    /**
     * poll与offer相对应的 带超时的方法,
     */
    @Test
    public void testPollTimeOut() {
        BlockingQueue<String> queue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 5; i++) {
            queue.offer("");
        }
        for (int i = 0; i < 10; i++) {
            String poll = queue.poll();
            System.out.println("i = " + poll);
        }
    }
}

