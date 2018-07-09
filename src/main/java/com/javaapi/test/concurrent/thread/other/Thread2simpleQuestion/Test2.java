package com.javaapi.test.concurrent.thread.other.Thread2simpleQuestion;

import java.util.concurrent.TimeUnit;

/**
 * 测试调用run后，可以执行start
 * 
 */
public class Test2 {
	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("1");
			}
		});
		// 只是普通方法调用
		a.run();
		// 这才开启一个线程
		a.start();
//		Thread b = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("2");
//			}
//		});
	}
}
