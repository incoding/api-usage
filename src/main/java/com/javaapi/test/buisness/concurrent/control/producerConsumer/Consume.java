package com.javaapi.test.buisness.concurrent.control.producerConsumer;

import java.util.List;

/**测试消费
 * @author Administrator
 *
 */
public class Consume implements Runnable {
  private List container = null;
  private int  count;

  public Consume(List lst) {
    this.container = lst;
  }

  public void run() {

    while (true) {
      synchronized (container) {
        if (container.size() == 0) {
          try {
            container.wait();// 容器为空，放弃锁，等待生产
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        container.remove(0);
        container.notify();
        System.out.println("我吃了" + (++count) + "个");
      }
    }

  }

}