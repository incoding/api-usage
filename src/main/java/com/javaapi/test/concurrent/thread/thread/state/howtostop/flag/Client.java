package com.javaapi.test.concurrent.thread.thread.state.howtostop.flag;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * 1 可以设置标志位来取消任务
 * 2 但是如果使用了阻塞队列,在put方法阻塞后,即便设置标志位也不能取消任务
 */
public class Client {
    @Test
    public void test(){
        List<BigInteger> bigIntegers = null;
        try {
            bigIntegers = PrimeGenerator.aSecondOfPrimes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bigIntegers = " + bigIntegers);
    }
}
