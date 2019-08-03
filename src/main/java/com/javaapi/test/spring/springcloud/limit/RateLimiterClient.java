package com.javaapi.test.spring.springcloud.limit;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * https://blog.csdn.net/boling_cavalry/article/details/75174486
 * https://blog.csdn.net/tracy38/article/details/78685707
 * 单节点限流可以用本例子
 *
 */
public class RateLimiterClient {

    RateLimiter rateLimiter = RateLimiter.create(5.0);

    ExecutorService fixedThreadPool = new ThreadPoolExecutor(8, 16, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>());


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            fixedThreadPool.submit(() -> {
                business();
            });
        }
        TimeUnit.HOURS.sleep(1);

    }
    private void business(){
        if (tryAcquire()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务执行");
        }else{
            System.out.println("限制流量");
        }
    }

    private boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

}
