package com.javaapi.test.concurrent.thread.thread;

import org.junit.Test;

/**
 * https://blog.csdn.net/bzwm/article/details/3881392
 * 2 Thread,join的使用
 *
 * 原理 Thread 的  native 方法 isAlive
 * 以及 Object 的wait 方法组合而成
 *
 */
public class JoinThread implements Runnable {
	public static int a = 0;

	public void run() {
		for (int k = 0; k < 5; k++) {
			a = a + 1;
		}
	}

	/**
	 * 		//1调用t.join()后,t线程执行完成后才会执行下面的输出,始终输出5

	 */
	@Test
	public void test(){
		Runnable r = new JoinThread();
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		System.out.println(a);
	}

	/**
	 * 2 如果注释掉t.join(),则并不是始终输出5
	 */
	@Test
	public void testNonJoin(){
		Runnable r = new JoinThread();
		Thread t = new Thread(r);
		t.start();
		//1调用t.join()后,t线程执行完成后才会执行下面的输出,始终输出5
		//2 如果注释掉t.join(),则并不是始终输出5
//		t.join();
		System.out.println("end");
		System.out.println(a);
	}
}