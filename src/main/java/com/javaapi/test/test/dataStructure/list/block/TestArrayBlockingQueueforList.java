package com.javaapi.test.test.dataStructure.list.block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * for array
 * 
 */
public class TestArrayBlockingQueueforList {
	public ReentrantLock	lock		= new ReentrantLock();
	public Condition		condition	= lock.newCondition();
	public List<Integer>	list		= new ArrayList<Integer>();
	boolean					isEmpty		= true;

	public static void main(String[] args) {
		TestArrayBlockingQueueforList test = new TestArrayBlockingQueueforList();
		Resource res = new Resource();
		new Thread(new ProducerThread(test.getCondition(), test.getLock(), res))
				.start();
		new Thread(new ConsumerThread(test.getCondition(), test.getLock(), res))
				.start();
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public void setLock(ReentrantLock lock) {
		this.lock = lock;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
