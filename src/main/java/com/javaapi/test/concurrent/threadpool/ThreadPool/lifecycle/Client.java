package com.javaapi.test.concurrent.threadpool.ThreadPool.lifecycle;

import com.javaapi.test.concurrent.threadpool.ThreadPool.queueStrategy.ThreadPoolTest;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * refer  https://blog.csdn.net/u010412719/article/details/52132601
 * shutdownnow 是通过想线程发送中断信号实现的 refer http://xtu-xiaoxin.iteye.com/blog/649677
 *  如果线程代码没有处理中断代码,那么这个线程是无法关闭的.refer https://stackoverflow.com/questions/38826985/executorservice-shutdownnow-doesnt-stop-the-thread
 */
public class Client extends ThreadPoolTest {

    /**
     * shutdown()是一个平缓的关闭过程，线程池停止接受新的任务，同时等待已经提交的任务执行完毕，包括那些进入队列还没有开始的任务
     */
    @Test
    public void testShutDown() {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        int queueCapacity = 5;
        ThreadPoolExecutor newFixedThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(queueCapacity));
        printStatus(newFixedThreadPool);

        for (int i = 0; i < 15; i++) {
            executeTask(newFixedThreadPool);

        }
        newFixedThreadPool.shutdown();

        // 如果关闭后继续提交任务,会导致异常
//        executeTask(newFixedThreadPool);

        status(newFixedThreadPool);
    }


    /**
     * 1 线程池执行shutDownNow 后,线程接受到中断信号,
     * 2 它试图终止线程的方法是通过调用Thread.interrupt()方法来实现的，但是大家知道，这种方法的作用有限，如果线程中没有sleep 、wait、Condition、定时锁等应用, interrupt()方法是无法中断当前的线程的。所以，ShutdownNow()并不代表线程池就一定立即就能退出，它可能必须要等待所有正在执行的任务都执行完成了才能退出。
     *
     * 3 shutdownNow()是一个立即关闭过程，线程池停止接受新的任务，同时线程池取消所有执行的任务和已经进入队列但是还没有执行的任务，这时候线程池处于STOP状态。
     */
    @Test
    public void testShutDownNow() {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        int queueCapacity = 5;
        ThreadPoolExecutor newFixedThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(queueCapacity));
        printStatus(newFixedThreadPool);

        for (int i = 0; i < 15; i++) {
            executeTask(newFixedThreadPool);
        }
        newFixedThreadPool.shutdownNow();

        // 如果关闭后继续提交任务,会导致异常
//        executeTask(newFixedThreadPool);

        status(newFixedThreadPool);
    }

    private void status(ThreadPoolExecutor newFixedThreadPool) {
        printStatus(newFixedThreadPool);
        while (!newFixedThreadPool.isTerminated()) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printStatus(newFixedThreadPool);
    }

    private void executeTask(ThreadPoolExecutor newFixedThreadPool) {
        newFixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(name+"中断");
                }
                System.out.println("线程" + name+"执行完毕");
            }
        });
    }

    private void printStatus(ThreadPoolExecutor newFixedThreadPool) {
        System.out.println("-----------");
        System.out.println("isShutdown = " + newFixedThreadPool.isShutdown());
        System.out.println("isTerminating = " + newFixedThreadPool.isTerminating());
        System.out.println("isTerminated = " + newFixedThreadPool.isTerminated());
    }

}
