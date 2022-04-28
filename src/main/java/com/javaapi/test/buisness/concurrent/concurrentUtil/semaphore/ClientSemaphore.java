package com.javaapi.test.buisness.concurrent.concurrentUtil.semaphore;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class ClientSemaphore {

    /**
     * release 是增加令牌permits
     * accquire 是提取令牌 permits
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        System.out.println("semaphore = " + semaphore);
        semaphore.release();
        System.out.println("semaphore = " + semaphore);
        semaphore.acquire();
        System.out.println("semaphore = " + semaphore);

    }
}
