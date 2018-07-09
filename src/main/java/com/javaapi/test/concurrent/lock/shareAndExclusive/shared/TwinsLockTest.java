package com.javaapi.test.concurrent.lock.shareAndExclusive.shared;

import java.util.concurrent.locks.Lock;

/**
 * 参考
 * http://blog.csdn.net/fuyuwei2015/article/details/72571659
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run(){
                for(;;){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                    }
                }
            }
        }

        for(int i=0;i<10;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
                System.out.println("----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}