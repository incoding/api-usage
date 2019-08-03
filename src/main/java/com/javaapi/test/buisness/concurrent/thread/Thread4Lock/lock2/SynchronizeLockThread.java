package com.javaapi.test.buisness.concurrent.thread.Thread4Lock.lock2;

import java.util.concurrent.locks.Lock;

/**
 * 1 同步锁,思索的例子, 2 线程通信 :wait,condition,阻塞队列<br>
 * Lock 支持更细粒得锁操作</br>
 * Lock是无阻塞锁,synchronize是阻塞锁
 * Lock可实现公平锁,synchronize只能是非公平锁
 * Lock是代码级别实现的,synchronize是jvm级别实现的
 *
 * 
 */
public class SynchronizeLockThread extends Thread {
	private int threadNo;
	private Lock lock;

	public SynchronizeLockThread(int threadNo, Lock lock) {
		this.threadNo = threadNo;
		this.lock = lock;
	}

	/**
	 * 可以看到 Lock 和 synchronized 有一点明显的区别 —— </br>
	 * <p> lock 必须在 finally 块中释放。否则，如果受保护的代码将抛出异常，锁就有可能永远得不到释放！</p>
	 * </br>这一点区别看起来可能没什么，但是实际上，它极为重要。忘记在 finally 块中释放锁，可能会在程序中留下一个定时炸弹，当有一天炸弹爆炸时，您要花费很大力气才有找到源头在哪。而使用同步，JVM 将确保锁会获得自动释放。
	 **/
	public void run() {
		lock.lock();
		try{
			// 这样会串行执行,这代码
			for (int i = 1; i < 10; i++) {
				System.out.println("No." + threadNo + ":" + i);
			}
		}finally{
			lock.unlock();

		}
	}
}
