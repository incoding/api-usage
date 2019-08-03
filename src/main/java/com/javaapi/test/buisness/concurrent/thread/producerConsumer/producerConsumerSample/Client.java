package com.javaapi.test.buisness.concurrent.thread.producerConsumer.producerConsumerSample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * kk 自测
 */
public class Client {


    public static Integer size = 5;

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        Object moitor = new Object();
        ConsumerThread consumerThread = new ConsumerThread(list,moitor);
        consumerThread.start();


        ProducerThread producerThread = new ProducerThread(list, moitor, size);
        producerThread.start();
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
