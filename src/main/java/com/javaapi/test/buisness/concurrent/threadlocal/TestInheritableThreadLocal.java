package com.javaapi.test.buisness.concurrent.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试支持继承数据的 InheritableThreadLocal
 */
public class TestInheritableThreadLocal {

    public static final int CORE_SIZE = 10;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_SIZE, 20, 1000, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(100));


    /**
     * 使用支持继承的  InheritableThreadLocal
     * 从主线程创建的子线程可以获取主线程的变量
     */
    @Test
    public void testInheritableThreadLocal() {
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(123);
        Thread thread = new InheritableChildThread(requestContext);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 普通 ThreadLocal不支持,创建子线程的时候将父线程关联变量传递给子线程
     */
    @Test
    public void testCommonThreadLocal() {
        RequestContext requestContext = new RequestContext();
        requestContext.setCount(123);
        Thread thread = new ChildThread(requestContext);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * InheritableThreadLocal 解决不了线程池场景
     * 因为线程池里的线程已经是初始化好的.
     */
    @Test
    public void test() {
        // 初始化一个线程,避免创建线程池线程时候就获得到父线程变量
        initCoreSize();
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(123);
        Runnable task = new Task(requestContext);

        executor.execute(task);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化核心线程池, 避免新建线程
     */
    private void initCoreSize() {
        for (int i = 0; i < CORE_SIZE; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("init" + finalI);
                }
            });

        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Data
    @AllArgsConstructor
    class InheritableChildThread extends Thread {
        private InheritableRequestContext requestContext;

        @Override
        public void run() {
            System.out.println("context count = " + requestContext.getCount());
        }
    }

    @Data
    @AllArgsConstructor
    class Task implements Runnable {
        private InheritableRequestContext requestContext;

        @Override
        public void run() {
            System.out.println("context count = " + requestContext.getCount());
        }
    }

    @Data
    private class InheritableRequestContext {
        private ThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();

        public Integer getCount() {
            return inheritableThreadLocal.get();
        }

        public void setCount(Integer count) {
            inheritableThreadLocal.set(count);
        }
    }

    @Data
    @AllArgsConstructor
    class ChildThread extends Thread {
        private RequestContext requestContext;

        @Override
        public void run() {
            System.out.println("context count = " + requestContext.getCount());
        }
    }

    @Data
    private class RequestContext {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        public Integer getCount() {
            return threadLocal.get();
        }

        public void setCount(Integer count) {
            threadLocal.set(count);
        }
    }
}
