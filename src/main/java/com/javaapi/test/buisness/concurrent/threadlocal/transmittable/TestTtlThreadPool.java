package com.javaapi.test.buisness.concurrent.threadlocal.transmittable;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * refer
 * https://github.com/alibaba/transmittable-thread-local#-%E9%9C%80%E6%B1%82%E5%9C%BA%E6%99%AF
 */
public class TestTtlThreadPool {


    public static final int CORE_SIZE = 10;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_SIZE, 20, 1000, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(100));

    /**
     * 使用原始类型,然后包装
     */
    @Test
    public void testInheritableThreadLocal() {
        initCoreSize();
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Runnable task = new Task(requestContext);
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        executor.submit(ttlRunnable);
    }

    /**
     * 通过使用特定线程池
     * 省去每次Runnable和Callable传入线程池时的修饰，这个逻辑可以在线程池中完成。
     */
    @Test
    public void test() {
        // 额外的处理，生成修饰了的对象executorService
        initCoreSize();
        ExecutorService executorService = TtlExecutors.getTtlExecutorService(executor);

        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Runnable task = new Task(requestContext);
        executorService.submit(task);
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
        private TransmittableThreadLocal<Integer> ttl = new TransmittableThreadLocal<>();

        public Integer getCount() {
            return ttl.get();
        }

        public void setCount(Integer count) {
            ttl.set(count);
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
}
