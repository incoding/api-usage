package com.javaapi.test.test.dataStructure.list.block;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConsumerThread implements Runnable {
	public Condition	condition;
	public Lock			lock;
	public Resource		resource;

	public ConsumerThread(Condition condition, Lock lock, Resource resource) {
		super();
		this.condition = condition;
		this.lock = lock;
		this.resource = resource;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			try {
				while (!resource.isFull()) {
					condition.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("消费");
			resource.setFull(false);
			condition.signal();
		} finally {
			lock.unlock();
		}

	}

}
