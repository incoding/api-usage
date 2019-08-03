package com.javaapi.test.buisness.pattern.concrete.singleton.perfect.holder;

/**
 * concurrence safe,lazy load
 * 
 */
public class Singleton2 {
	private static class SingletonHolder {
		private static final Singleton2 INSTANCE = new Singleton2();
	}

	private Singleton2() {
	}

	public static final Singleton2 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public static void main(String[] args) {
		System.out.println(Singleton2.getInstance());
	}
}