package com.javaapi.test.concurrent.thread.Thread4Lock.synchronizeLock;

/**
 * 1、对于同步的方法或者代码块来说，必须获得对象锁才能够进入同步方法或者代码块进行操作；
 * <p>
 * <p>
 * 2、如果采用method级别的同步，则对象锁即为method所在的对象，如果是静态方法，对象锁即指method所在的 Class对象(唯一)；
 * <p>
 * <p>
 * 3、对于代码块，对象锁即指synchronized(abc)中的abc；
 *
 * @see http://enetor.iteye.com/blog/986623
 */

/**
 * 1 同步代码块
 */
public class SynchronizeBlockThreadTmp extends Thread {
    private int threadNo;
    private String lock;

    public SynchronizeBlockThreadTmp(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    public void run() {
        // 不会串行,每个线程持有不同的对象锁
        synchronized (new Object()) {
            for (int i = 1; i < 10; i++) {
                System.out.println("No." + threadNo + ":" + i);
            }
        }
    }

//    public void run() {
//        //注意,会串行,"A"是相同的
//        synchronized ("A") {
//            for (int i = 1; i < 10; i++) {
//                System.out.println("No." + threadNo + ":" + i);
//            }
//        }
//    }
}
