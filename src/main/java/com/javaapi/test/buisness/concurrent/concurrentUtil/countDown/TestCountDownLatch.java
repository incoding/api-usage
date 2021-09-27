package com.javaapi.test.buisness.concurrent.concurrentUtil.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.iteye.com/topic/1002652
 * http://www.importnew.com/15731.html
 */
public class TestCountDownLatch {
	static int a = 0;
	static int su =0;
	public static void main(String[] args) {
		a();
		b();
	}
    public static void a(){
    	ExecutorService threadPool = Executors.newFixedThreadPool(1);
		final CountDownLatch answers = new CountDownLatch(10);
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					a= 10;
			    	for(int i=0;i<a;i++){
			    		su =i;
			    		System.out.println("su1===="+su);
			    		answers.countDown();
			    	}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		threadPool.shutdown();
		try {
			answers.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static void b(){
    	   System.out.println("su2==="+su);
    }

}
