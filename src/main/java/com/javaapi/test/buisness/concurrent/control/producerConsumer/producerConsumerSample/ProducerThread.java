package com.javaapi.test.buisness.concurrent.control.producerConsumer.producerConsumerSample;

import java.util.List;

/**
 * Created by user on 17/12/16.
 */
public class ProducerThread extends Thread{


    private List<String> list;
    private  Integer limit;
    private  Object moitor;

    public ProducerThread(List<String> list, Object moitor, Integer limit) {

        this.list = list;
        this.limit = limit;
        this.moitor = moitor;
    }

    @Override
    public void run() {
        synchronized (moitor) {
            while (list.size() < limit) {
                list.add(String.valueOf(list.size()));
            }
            moitor.notify();
            System.out.println("通知消费者, 必须生产者这里释放monitor锁之后,消费才能获取到锁,然后从wait中醒来");
        }

    }
}
