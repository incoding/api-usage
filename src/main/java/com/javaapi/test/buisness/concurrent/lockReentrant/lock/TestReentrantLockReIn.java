package com.javaapi.test.buisness.concurrent.lockReentrant.lock;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @1 测试可重入
 *
 */
public class TestReentrantLockReIn {
	private ReentrantLock lock = null;
	// 用于线程同步访问的共享数据
	public int data = 100;

	public TestReentrantLockReIn() {
		// @2 创建一个自由竞争的可重入锁
		lock = new ReentrantLock();
	}

	public static void main(String[] args) {

		TestReentrantLockReIn tester = new TestReentrantLockReIn();

		// 测试可重入，函数testReentry() 执行获取锁后，显示信息的功能
		tester.testReentry();
		// 能执行到这里而不阻塞，表示锁可重入
		tester.testReentry();
		// 再次重入
		tester.testReentry();

		//@1  释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
//		tester.getLock().unlock();
		tester.getLock().unlock();
		tester.getLock().unlock();

		// 启动3个线程测试在锁保护下的共享数据data的访问
		tester.test();
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public void test() {
		new Thread(new WorkerThread(this)).start();
		new Thread(new WorkerThread(this)).start();
		new Thread(new WorkerThread(this)).start();
	}

	public void testReentry() {
		lock.lock();

		Calendar now = Calendar.getInstance();

		System.out.println(now.getTime() + " " + Thread.currentThread()
				+ " get lock.");
	}

	// 线程调用的方法
	public void testRun() throws Exception {
		// 加锁
		lock.lock();

		Calendar now = Calendar.getInstance();
		try {
			// 获取锁后显示 当前时间 当前调用线程 共享数据的值（并使共享数据 + 1）
			System.out.println(now.getTime() + " " + Thread.currentThread()
					+ " accesses the data " + data++);

			// 模拟其他处理，这里假设休眠一下
			Thread.sleep(500);

		} finally {
			// 解锁
			lock.unlock();
		}
	}
}

