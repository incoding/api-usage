package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool;

import com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.queueStrategy.ThreadPoolTest;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPool里的功能
 */
public class TestThreadPoolFunction extends ThreadPoolTest {

    @Test
    public void newCachedThreadPool() {
        int redundant = 15;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        checkEsStatus((ThreadPoolExecutor) newCachedThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }

    @Test
    public void newFixedThreadPool() {
        int redundant = 10;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(CORE_SIZE);
        checkEsStatus((ThreadPoolExecutor) newFixedThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }
    @Test
    public void newScheduledThreadPool() {
        int redundant = 10;
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(MAX_SIZE);
        checkEsStatus((ThreadPoolExecutor) newScheduledThreadPool, QUEUE_SIZE, MAX_SIZE, redundant);
    }

    @Test
    public void newSingleThreadExecutor() {
        ExecutorService newScheduledThreadPool = Executors.newSingleThreadExecutor();
        checkEsStatus((ThreadPoolExecutor) newScheduledThreadPool, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
    }

    @Test
    public void newSingleThreadScheduledExecutor() {
        ExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        checkEsStatus((ThreadPoolExecutor) newSingleThreadScheduledExecutor, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
    }
}
