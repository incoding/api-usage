package com.javaapi.test.concurrent.lock.fairAndUnfair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ReentrantLock 中分为公平锁和非公平锁
 * https://www.cnblogs.com/xiongmaotailang/p/6139214.html
 *
 * 可以明显看出，在非公平获取的过程中，“插队”现象非常严重，获取锁的线程根本不顾及sync队列中等待的线程，而是能再次立刻获取。反观公平获取的过程，锁的获取就类似线性化的

  公平锁, 会按照进入等待队列的顺序来获取锁
  非公平锁,线程切换开销小,  但是会使某些线程饥饿

 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void testFair(){
        fair();
    }

    @Test
    public void testUnFair(){
        unfair();
    }
    public static void fair() {

        System.out.println("fair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(fairLock)) {
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        // sleep 5000ms
    }


    public static void unfair() {
        System.out.println("unfair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(unfairLock)) {
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        // sleep 5000ms
    }


    private static class Job implements Runnable {

        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Lock by:"
                            + Thread.currentThread().getName() + " and "
                            + ((ReentrantLock2) lock).getQueuedThreads()
                            + " waits.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }
        private static final long serialVersionUID = 1773716895097002072L;
        public Collection<Thread> getQueuedThreads() {
            List<Thread> threads = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(threads);
            return threads;
        }
    }
}