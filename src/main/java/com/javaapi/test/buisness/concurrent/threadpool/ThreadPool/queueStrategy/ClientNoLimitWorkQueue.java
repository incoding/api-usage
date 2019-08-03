package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.queueStrategy;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/12.
 */
public class ClientNoLimitWorkQueue extends ThreadPoolTest{


    @Test
    public void test() {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.DAYS, new LinkedBlockingQueue<>());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            tpe.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.DAYS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        System.out.println("done = ");

    }

    /**问题  如果 corePoolSize = 0 且 阻塞队列是无界的。线程池将如何工作？
     * refer https://xilidou.com/2018/02/09/thread-corepoolsize/
     * 自己试验后给出的答案,编程单线程执行
     */
    @Test
    public void test2() {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(0, 10, 5000, TimeUnit.DAYS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 300; i++) {
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.DAYS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"执行完成");
                    printStats(tpe);
                }

            });
        }
        printStats(tpe);
        System.out.println("done");
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
