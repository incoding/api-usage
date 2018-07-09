package com.javaapi.test.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("创建一个新的线程");
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        System.out.println("eh121 = " + t.getUncaughtExceptionHandler());
        System.out.println("t = " + t.getName());
        return t;
    }

}