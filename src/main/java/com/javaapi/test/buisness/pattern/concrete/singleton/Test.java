package com.javaapi.test.buisness.pattern.concrete.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable a = new Job(i);
			System.out.println("当前循环次数是" + i);
			es.execute(a);
		}
		es.shutdown();
	}
}
