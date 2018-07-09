package com.javaapi.test.concurrent.thread.Thread4Lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * JDK Lock接口只有几个实现而已
 * 
 */
public class TestLock3 {
	/**
	 * java.util.concurrent.lock 中的 Lock 框架是锁定的一个抽象，它允许把锁定的实现作为 Java
	 * 类，而不是作为语言的特性来实现。这就为 Lock 的多种实现留下了空间，各种实现可能有不同的调度算法、性能特性或者锁定语义。
	 * ReentrantLock 类实现了 Lock ，它拥有与 synchronized
	 * 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性
	 * 。此外，它还提供了在激烈争用情况下更佳的性能。（换句话说，当许多线程都想访问共享资源时，JVM
	 * 可以花更少的时候来调度线程，把更多时间用在执行线程上
	 */
	/**
	 * 如果没用到以下特性，最好还世用sychronized关键字 ReentrantLock 可轮询，可中断
	 * 
	 * @see http://www.cnblogs.com/donlianli/p/3203961.html
	 * 
	 */
	@Test
	public void test() {
		
	}


	/**
	 * 如果发现该操作已经在执行中则不再执行（有状态执行） http://my.oschina.net/noahxiao/blog/101558
	 */
	@Test
	public void test3() {
		Lock lock = new ReentrantLock();
		if (lock.tryLock()) { // 如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
			try {
				// 操作
			} finally {
				lock.unlock();
			}
		}
	}

	/**
	 * 不公平锁与公平锁的区别： </br>
	 * 公平情况下，操作会排一个队按顺序执行，来保证执行顺序。（会消耗更多的时间来排队）</br>
	 * 不公平情况下，是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队。（如果不关心顺序，这个速度会更快）
	 */
	@Test
	public void test4() {
		ReentrantLock lock = new ReentrantLock(); // 参数默认false，不公平锁
		// private ReentrantLock lock = new ReentrantLock(true); // 公平锁
		try {
			lock.lock(); // 如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
			// 操作
		} finally {
			lock.unlock();
		}
	}
	/**
	 * 如果发现该操作已经在执行，则尝试等待一段时间，等待超时则不执行（尝试等待执行）
	 */
	@Test
	public void test5() {
		Lock lock=new ReentrantLock();
		try{
			if(lock.tryLock(5, TimeUnit.SECONDS)){
				try{
					
				}finally{
					lock.unlock();
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	/**
	 * 如果发现该操作已经在执行，等待执行。这时可中断正在进行的操作立刻释放锁继续下一操作
	 */
	@Test
	public void test6() {
		Lock lock=new ReentrantLock();
		try {
		    lock.lockInterruptibly();
		    //操作
		} catch (InterruptedException e) {
		    e.printStackTrace();
		} finally {
		    lock.unlock();
		}
	}

}
