package com.javaapi.test.buisness.concurrent.locksync.synchronizeLock;


/**
 * 1、对于同步的方法或者代码块来说，必须获得对象锁才能够进入同步方法或者代码块进行操作；
 * 
 * 
 * 2、如果采用method级别的同步，则对象锁即为method所在的对象，如果是静态方法，对象锁即指method所在的 Class对象(唯一)；
 * 
 * 
 * 3、对于代码块，对象锁即指synchronized(abc)中的abc；
 * @see http://enetor.iteye.com/blog/986623
 */

import com.javaapi.test.buisness.concurrent.locksync.synchronizeLock2.SynchronizeMethod;

/**
 * 2 同步方法
 * 
 * 3 Thread.sleep()得调用不会释放同步监听器
 * 
 */
public class SynchronizeMethodThread extends Thread {
	private int threadNo;
	private String lock;

	public SynchronizeMethodThread(int threadNo, String lock) {
		this.threadNo = threadNo;
		this.lock = lock;
	}
	
	public void run() {
		// 这样会串行执行,这代码
		System.out.println("线程=>"+threadNo+"获取执行机会");
		SynchronizeMethod.synchronizedMethod(threadNo);
	}
}
