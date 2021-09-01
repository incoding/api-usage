package com.javaapi.test.buisness.concurrent.thread.Thread6Sample;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2021/9/1.
 * refer https://www.jianshu.com/p/fd58b10011ce
 */
class LockCoditionTest {
    final Business business = new Business();

    public static void main(String[] args) {
        new LockCoditionTest().init();
    }

    private void init() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    business.sub2("B");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    business.sub3("C");
                }
            }
        }).start();

        for (int i = 0; i <= 10; i++) {
            business.main("A");
        }
    }

    class Business {
        private int flag = 1;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public void sub2(String s) {
            lock.lock();
            try {
                if (flag != 2) {
                    condition2.await();
                }

                System.out.println("B线程输出" + s);

                flag = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void sub3(String s) {
            lock.lock();
            try {
                if (flag != 3) {
                    condition3.await();
                }
                System.out.println("C线程输出" + s);
                flag = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void main(String s) {
            lock.lock();
            try {
                if (flag != 1) {
                    condition1.await();
                }
                System.out.println("main线程输出" + s);
                flag = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}