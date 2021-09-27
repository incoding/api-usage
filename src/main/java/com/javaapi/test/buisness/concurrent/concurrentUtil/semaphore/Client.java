package com.javaapi.test.buisness.concurrent.concurrentUtil.semaphore;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *http://www.cnblogs.com/whgw/archive/2011/09/29/2195555.html
 *  Semaphore当前在多线程环境下被扩放使用，操作系统的信号量是个很重要的概念，在进程控制方面都有应用。Java 并发库 的Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。比如在Windows下可以设置共享文件的最大客户端访问个数。
 */
public class Client {
    @Test
    public void test() {
        // 线程池

        ExecutorService exec = Executors.newCachedThreadPool();

        // 只能5个线程同时访问

        final Semaphore semp = new Semaphore(5);

        // 模拟20个客户端访问

        for (int index = 0; index < 20; index++) {

            final int NO = index;

            Runnable run = new Runnable() {

                public void run() {

                    try {

                        // 获取许可

                        semp.acquire();

                        System.out.println("Accessing: " + NO);

                        Thread.sleep((long) (Math.random() * 10000));

                        // 访问完后，释放

                        semp.release();

                        System.out.println("-----------------" + semp.availablePermits());

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            };

            exec.execute(run);

        }

        // 退出线程池
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();


    }
}
