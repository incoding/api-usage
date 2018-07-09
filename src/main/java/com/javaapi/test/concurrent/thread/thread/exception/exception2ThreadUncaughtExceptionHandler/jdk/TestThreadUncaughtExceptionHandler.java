package com.javaapi.test.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler.jdk;

import com.javaapi.test.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler.MyUnchecckedExceptionhandler;

import java.util.concurrent.TimeUnit;

/**
 * 实验jdk自带的线程异常处理机制
 */
public class TestThreadUncaughtExceptionHandler {
    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            final int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (finalI == 4 || finalI == 5 || finalI == 6) {
                        throw new RuntimeException("线程="+finalI+"=扔出运行时候异常");
                    }
                    System.out.println("finalI = " + finalI+" =运行完成");
                }
            });
            if (finalI == 4 || finalI == 5 || finalI == 6) {
                t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
            }
            t.start();
        }
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
