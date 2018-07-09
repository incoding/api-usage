package com.javaapi.test.concurrent.thread.thread.state.howtostop.interrupt;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2018/6/18
 */
public class Client {
    /**
     * 线程池里的线程,无法手动响应中断,因为被线程池包装过
     */
    @Test
    public void testThreadPoolInterrupt(){
        List<BigInteger> bigIntegers = null;
        try {
            BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);

            bigIntegers = PrimeProducer.aSecondOfPrimes(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bigIntegers = " + bigIntegers);
    }

    /**
     * 当 future 抛出TimeoutException 或InterruptedException,如果你知道不再需要结果,那么就可以调用Future.cancel来取消任务
     * future.cancel(true);
     * https://stackoverflow.com/questions/21445224/what-does-future-cancel-do-if-not-interrupting
     * https://segmentfault.com/a/1190000007961347
     */
    @Test
    public void testFutureCancel(){
        List<BigInteger> bigIntegers = null;
        try {
            BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);

            bigIntegers = PrimeProducer.futureCancel(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bigIntegers = " + bigIntegers);
    }


    /**
     * 关闭整个线城池来关闭所有线程
     */
    @Test
    public void testShutdownNow(){
        List<BigInteger> bigIntegers = null;
        try {
            BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);

            bigIntegers = PrimeProducer.shutdownNow(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bigIntegers = " + bigIntegers);
    }
}
