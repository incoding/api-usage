package com.javaapi.test.buisness.concurrent.thread.waitnotify.waitNotifyQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
  /**锁对象*/
  final Lock      lock     = new ReentrantLock();
  /**
   写线程条件
   *
   */
  final Condition notFull  = lock.newCondition();
  /**
   * 读线程条件
   */
  final Condition notEmpty = lock.newCondition();
  /**
   *  缓存队列
   */
  final Object[]  items    = new Object[100];
  /** 写索引 */
  int             putptr;
  /** 读索引 */
  int             takeptr;
  /** 队列中存在的数据个数 */
  int count;


  public void put(Object x) throws InterruptedException {
    lock.lock();
    try {
      while (count == items.length)
        // 如果队列满了
        notFull.await();// 阻塞写线程
      items[putptr] = x;// 赋值
      if (++putptr == items.length) putptr = 0;// 如果写索引写到队列的最后一个位置了，那么置为0
      ++count;// 个数++
      notEmpty.signal();// 唤醒读线程
      // 打印写入的数据
      System.out.println(Thread.currentThread().getName() + " put  "+ (Integer)x);

    } finally {
      lock.unlock();
    }
  }

  public Object take() throws InterruptedException {
    lock.lock();
    try {
      while (count == 0)
        // 如果队列为空
        notEmpty.await();// 阻塞读线程
      Object x = items[takeptr];// 取值
      if (++takeptr == items.length) takeptr = 0;// 如果读索引读到队列的最后一个位置了，那么置为0
      --count;// 个数--
      notFull.signal();// 唤醒写线程
      // 打印取出的数据
      System.out.println(Thread.currentThread().getName() + " take "+ (Integer)x);
      return x;
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    BoundedBuffer boundedBuffer = new BoundedBuffer();
    try {
      boundedBuffer.put("a");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}