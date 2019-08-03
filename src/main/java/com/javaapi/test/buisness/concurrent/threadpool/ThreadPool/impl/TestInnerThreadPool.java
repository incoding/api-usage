package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.impl;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 好
 * http://zhanjindong.com/2015/03/30/java-concurrent-package-ThreadPoolExecutor
 * https://xilidou.com/2018/02/09/thread-corepoolsize/
 * https://juejin.im/post/5a902d86f265da4e710f7116
 */
public class TestInnerThreadPool {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;


    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    @Test
    public void testCtl() {
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println("COUNT_BITS = Integer.SIZE - 3 = " + COUNT_BITS);
        Integer right = 1 << COUNT_BITS;
        String rightBinary = Integer.toBinaryString(right);
        System.out.println("1 << COUNT_BITS = " + rightBinary + ",1 << COUNT_BITS length is " + rightBinary.length());
        int CAPACITY = (1 << COUNT_BITS) - 1;
        String capString = Integer.toBinaryString(CAPACITY);
        System.out.println("(1 << COUNT_BITS) - 1 = " + capString + ",(1 << COUNT_BITS) - 1 length is " + capString.length());
    }


    /**
     * 只有RUNNING是负数
     */
    @Test
    public void testStatus1() {
        int RUNNING = -1 << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;
        System.out.println("RUNNING    = " + RUNNING);
        System.out.println("SHUTDOWN   = " + SHUTDOWN);
        System.out.println("STOP       = " + STOP);
        System.out.println("TIDYING    = " + TIDYING);
        System.out.println("TERMINATED = " + TERMINATED);
    }


    /**
     * TODO 补码 , 负数二进制 ,二进制转十进制
     */
    @Test
    public void testStatus() {

        String str = Integer.toBinaryString(-1);
        System.out.println(str + " = -1, length = " + str.length());
        String runningString = Integer.toBinaryString(RUNNING);
        System.out.println(runningString + " = RUNNING = -1 << COUNT_BITS, length = " + runningString.length());
        String shutdownString = Integer.toBinaryString(SHUTDOWN);
        System.out.println(shutdownString + " = SHUTDOWN = 0 << COUNT_BITS, length = " + shutdownString.length());
        String stopString = Integer.toBinaryString(STOP);
        System.out.println(stopString + " = STOP = 1 << COUNT_BITS, length = " + stopString.length());
        String tidyingString = Integer.toBinaryString(TIDYING);
        System.out.println(tidyingString + " = TIDYING = 2 << COUNT_BITS, length = " + tidyingString.length());
        String terminatedString = Integer.toBinaryString(TERMINATED);
        System.out.println(terminatedString + " = TERMINATED = 3 << COUNT_BITS, length = " + terminatedString.length());

    }

    @Test
    public void testIntegerBinary() {
        for (int i = 0; i > -10; i--) {
            String s = Integer.toBinaryString(i);
            System.out.println("i = " + i + ",binaryString = " + s + ",length = " + s.length());
        }
    }

    @Test
    public void test() {
        System.out.println("ctl = " + Integer.toBinaryString(new AtomicInteger(ctlOf(RUNNING, 0)).intValue()));
        System.out.println("ctl = " + Integer.toBinaryString(new AtomicInteger(ctlOf(SHUTDOWN, 0)).intValue()));
        System.out.println("ctl = " + Integer.toBinaryString(new AtomicInteger(ctlOf(STOP, 0)).intValue()));
        System.out.println("ctl = " + Integer.toBinaryString(new AtomicInteger(ctlOf(TIDYING, 0)).intValue()));
        System.out.println("ctl = " + Integer.toBinaryString(new AtomicInteger(ctlOf(TERMINATED, 0)).intValue()));


    }


    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
}
