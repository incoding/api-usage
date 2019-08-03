package com.javaapi.test.buisness.concurrent.thread.producerConsumer;

import java.util.List;

public class Product implements Runnable {
  private List container = null;
  private int  count;

  public Product(List lst) {
    this.container = lst;
  }

  public void run() {
    while (true) {
      synchronized (container) {
        if (container.size() > MultiThread.MAX) {
          // 如果容器超过了最大值，就不要在生产了，等待消费
          try {
            container.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        container.add(new Object());
        container.notify();
        System.out.println("我生产了" + (++count) + "个");
      }
    }

  }

}
