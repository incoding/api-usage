package com.javaapi.test.buisness.concurrent.lock.condition;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2019/12/21
 */
public class MultipleLock {
    private Lock resourceA = new ReentrantLock();
    private Lock resourceB = new ReentrantLock();
    private Lock resourceC = new ReentrantLock();


    @Test
    public void test() {
        resourceA.lock();
        System.out.println("获取锁A");
        try {
            resourceB.lock();
            System.out.println("获取锁B");

        } finally {
            resourceA.unlock();
            System.out.println("释放锁A");
        }
        try {
            resourceC.lock();
            System.out.println("获取锁C");
        } finally {
            resourceB.unlock();
            System.out.println("释放锁B");
        }
        try {
            System.out.println("结束");
        } finally {
            resourceC.unlock();
            System.out.println("释放锁C");
        }
    }

    @Test
    public void test2() {
        synchronized (resourceA) {
            System.out.println("获取锁A");

            synchronized (resourceB) {
                System.out.println("获取锁B");

                synchronized (resourceC) {
                    System.out.println("获取锁C");
                    System.out.println("释放锁C");
                }
                System.out.println("释放锁B");

            }
            System.out.println("释放锁A");

        }


    }
}
