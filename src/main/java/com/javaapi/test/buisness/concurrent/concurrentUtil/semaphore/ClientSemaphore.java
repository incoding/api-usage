package com.javaapi.test.buisness.concurrent.concurrentUtil.semaphore;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class ClientSemaphore {
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
