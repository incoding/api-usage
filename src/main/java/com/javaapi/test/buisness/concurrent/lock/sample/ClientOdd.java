package com.javaapi.test.buisness.concurrent.lock.sample;

/**
 * Created by user on 2021/6/22.
 */
public class ClientOdd {
    private static int count = 0;
    private static final Object object = new Object();

    public static void main(String[] args) {
        new Thread(new printer(), "偶数线程，").start();
        new Thread(new printer(), "奇数线程，").start();
    }

    static class printer implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (object) {
                    // 打印数字，并立即释放锁
                    System.out.println(Thread.currentThread().getName() + "打印:" + count++);
                    object.notify();
                    // 此处判断，是为了打印完了100个数字后，程序能够正常结束，否则程序将一直等待下去，耗费系统资源。
                    if (count <= 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
