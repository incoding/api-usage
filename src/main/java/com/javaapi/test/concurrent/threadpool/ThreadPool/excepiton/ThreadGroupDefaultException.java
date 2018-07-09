package com.javaapi.test.concurrent.threadpool.ThreadPool.excepiton;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * refer https://www.jianshu.com/p/281958d20b04
 * ThreadGroup 默认提供了异常处理机制
 */
public class ThreadGroupDefaultException {
    @Test
    public void test(){
        Thread t  = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("nihao");
            }
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}