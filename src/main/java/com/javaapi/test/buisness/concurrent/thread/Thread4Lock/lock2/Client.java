package com.javaapi.test.buisness.concurrent.thread.Thread4Lock.lock2;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;


public class Client {


	/**
	 * 同步锁</br>
	 * @see http://blog.csdn.net/fw0124/article/details/6672522</br>
	 * http://tenyears.iteye.com/blog/48750</br>
	 * ReadWriteLock
	 */
	@Test
	public void synchronizeLock() {
		ReentrantLock lock = new ReentrantLock();
		for (int i = 1; i < 10; i++) {
            new SynchronizeLockThread(i, lock).start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
