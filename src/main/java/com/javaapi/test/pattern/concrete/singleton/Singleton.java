package com.javaapi.test.pattern.concrete.singleton;

/**
 * This Singleton is not reliable;
 * 
 */
public class Singleton {
	private static Singleton singleton;
	private String name;

	public String getName() {
		return name;
	}

	private Singleton(String string) {
		System.out.println("构造函数传入的参数是" + string);
		this.name = string;
	}

	public static Singleton getInstance(String string)
			throws InterruptedException {
		if (singleton == null) {
			if ("0".equals(string)) {
				Thread.sleep(500);
			}
			singleton = new Singleton(string);

		}
		return singleton;

	}
}
