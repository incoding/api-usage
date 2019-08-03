package com.javaapi.test.buisness.concurrent.thread.waitnotify.waitNotifyQueue.selfSample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 17/12/16.
 */
public class SelfQueue {
    // 缓存队列
    final Object[] items = new Object[10];
    private static Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();
    /**
     * 写索引
     */
    int putptr;
    /**
     * 读索引
     */
    int takeptr;
    /**
     * 队列中存在的数据个数
     */
    int count;


    public void put(Object x) {
//        synchronized (lock) {
        lock.lock();
        try {
            while (count == items.length) {
                try {
                    isFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            items[putptr++] = x;
            // 如果写索引写到队列的最后一个位置了，那么置为0
            if (putptr == items.length) {
                putptr = 0;
            }
            count++;
            isEmpty.signal();
            // 打印写入的数据
            System.out.println(Thread.currentThread().getName() + " put  "+ (Integer)x);
        } finally {
            lock.unlock();
        }
//        }

    }

    public Object take() {
        lock.lock();
        try {
            while (count == 0) {
                try {
                    isEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 取值
            Object x = items[takeptr++];
            if (takeptr == items.length) {
                // 如果读索引读到队列的最后一个位置了，那么置为0
                takeptr = 0;
            }
            count--;
            isFull.signal();
            // 打印取出的数据
            System.out.println(Thread.currentThread().getName() + " take "+ (Integer)x);
            return x;
        } finally {
            lock.unlock();
        }

    }
}
