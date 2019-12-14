package com.javaapi.test.buisness.concurrent.lockReentrant.lock;

//工作线程，调用TestServer.testRun
public class WorkerThread implements Runnable {

	private TestReentrantLockReIn tester = null;

	public WorkerThread(TestReentrantLockReIn testLock) {
		this.tester = testLock;
	}

	public void run() {
		// 循环调用，尝试加锁，并对共享数据+1，然后显示出来
		while (true) {
			try {
				// 调用tester.testRun()
				tester.testRun();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}