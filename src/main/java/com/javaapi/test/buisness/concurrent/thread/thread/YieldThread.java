package com.javaapi.test.buisness.concurrent.thread.thread;

/**
 * 4 线程yield,与优先级
 *
 */
public class YieldThread extends Thread {
	public static void main(String[] args) {
		for (int i = 1; i <= 2; i++) {
			YieldThread t=new YieldThread();
			t.start();
			if(i%2!=0)
				t.setPriority(MIN_PRIORITY);
			else
				t.setPriority(MAX_PRIORITY);
		}
	}
	@Override
	public void run() {
		System.out.println(getName()+"==>1");
		Thread.yield(); // 给其他线程执行的机会(优先级跟当前线程相同,或者比当前线程高的线程才能获得执行机会),但是也有可能立刻唤醒这个线程.
		System.out.println(getName()+"==>2");
	}
}