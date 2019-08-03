package com.javaapi.test.buisness.pattern.concrete.singleton.perfect.holder;

import java.util.concurrent.TimeUnit;

public class Singleton {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	private Singleton() {
	}

	private static final class Holder {
		private static final Singleton singleton = new Singleton();
		static {
			System.out.println("singleton init");
		}
	}

	public static Singleton getSingleton() {
		// TODO
		// 一个类中,内部类的private方法可以被直接调用?
		return Holder.singleton;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Singleton.getSingleton());
				}
			}).start();
		}
		 try {
		 TimeUnit.MINUTES.sleep(1);
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	}
}
