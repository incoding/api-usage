package com.javaapi.test.concurrent.threadpool.ThreadPool.queueStrategy;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by user on 16/12/12.
 */
public class TestThreadPoolQueueLimit extends ThreadPoolTest{


    @Test
    public void common() {
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
    }

    /**
     *  排队策略: 直接提交
     *  拒绝策略:默认
     * {activeCount=40, queueSize=0, corePoolSize=0, maximumPoolSize=2147483647} corePoolSize is full ||
     */
    @Test
    public void newCachedThreadPool() {
        int redundant = 15;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        checkEsStatus((ThreadPoolExecutor) newCachedThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }

    /**
     *  排队策略: 无界队列
     *  拒绝策略:默认
     */
    @Test
    public void newFixedThreadPool() {
        int redundant = 10;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(CORE_SIZE);
        checkEsStatus((ThreadPoolExecutor) newFixedThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }

    /**
     *  排队策略: 有界队列
     *  拒绝策略:默认
     */
    @Test
    public void testLimitedQueue() {
        int redundant = 10;
        ExecutorService newFixedThreadPool = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        checkEsStatus((ThreadPoolExecutor) newFixedThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }




}
