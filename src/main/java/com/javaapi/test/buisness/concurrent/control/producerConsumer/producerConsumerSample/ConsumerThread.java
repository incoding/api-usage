package com.javaapi.test.buisness.concurrent.control.producerConsumer.producerConsumerSample;

import java.util.List;

/**
 * Created by user on 17/12/16.
 */
public class ConsumerThread extends Thread {

    private final List<String> list;
    private final Object moitor;

    public ConsumerThread(List<String> list, Object moitor) {
        this.list = list;
        this.moitor = moitor;
    }

    @Override
    public void run() {
        synchronized (moitor) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列为空,等待数据");
                    moitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者被唤醒");
            }
            for (String item : list) {
                System.out.println("消费item = " + item);
            }

        }

    }
}
