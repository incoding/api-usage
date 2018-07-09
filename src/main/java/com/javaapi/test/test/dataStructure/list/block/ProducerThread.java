package com.javaapi.test.test.dataStructure.list.block;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerThread implements Runnable {
	public Condition	condition;
	public Lock			lock;
	public Resource		resource;

	public ProducerThread(Condition condition, Lock lock, Resource res) {
		this.condition = condition;
		this.lock = lock;
		this.resource = res;
	}

	@Override
	public void run() {

		lock.lock();
		try {
			try {
				while (resource.isFull()) {
					condition.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("生产");
			resource.setFull(true);
			condition.signal();
		} finally {
			lock.unlock();
		}

	}

}
