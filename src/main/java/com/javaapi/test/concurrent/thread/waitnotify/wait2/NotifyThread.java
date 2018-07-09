package com.javaapi.test.concurrent.thread.waitnotify.wait2;

import java.util.Calendar;

public class NotifyThread implements Runnable { 
	private TestWait tester = null; 
	public NotifyThread(TestWait tester) { 
	  this.tester = tester; 
	} 
	public void run() { 
	  while (true) { 
	   try { 
	    // 间隔1秒 
	    Thread.sleep(1000); 
	   } catch (InterruptedException e) { 
	    e.printStackTrace(); 
	   } 
	   // 同步访问 event 
	   synchronized (tester.getEvent()) { 
	    // 通知等在event上的一个线程 
				// tester.getEvent().notify();

	    // 通知等在event上的所有线程 
				tester.getEvent().notifyAll();
	    // 打印 "fire event" 信息。 
	    Calendar now = Calendar.getInstance(); 
	    System.out.println(now.getTime() + " N " + Thread.currentThread() + " fire event."); 
	   } 
	  } 
	} 
	}
