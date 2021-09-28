package com.javaapi.test.buisness.concurrent.concurrentUtil.cyclicbarrier;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * refer https://www.cnblogs.com/dolphin0520/p/3920397.html
 * <p>
 * CycleBarrier 比CountDownLatch 的优势在于， CycleBarrier 有parties 满足条件之后可以再次填充上次一样的parties ，还可以再一样的使用
 */
public class ClientCycleBarrier {
    @Test
    public void test() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                System.out.println("cyclicBarrier1 = " + cyclicBarrier);
                cyclicBarrier.await();
                System.out.println("cyclicBarrier1 result= " + cyclicBarrier);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("cyclicBarrier2 = " + cyclicBarrier);
                cyclicBarrier.await();
                System.out.println("cyclicBarrier2 result= " + cyclicBarrier);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("cyclicBarrier3 = " + cyclicBarrier);
                cyclicBarrier.await();
                System.out.println("cyclicBarrier3 result= " + cyclicBarrier);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("done");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
