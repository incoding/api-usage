package com.javaapi.test.buisness.concurrent.control.waitnotify.wait2;

import java.util.Calendar;

public class WaitThread implements Runnable { 
	private TestWait tester = null; 
	public WaitThread(TestWait tester) { 
	  this.tester = tester; 
	} 
	public void run() { 
	  Calendar now = Calendar.getInstance(); 
	  System.out.println(now.getTime() + " W " + Thread.currentThread() + " wait for event."); 
	  while (true) { 
	   try { 
	    // 同步访问 event 
	    synchronized (tester.getEvent()) { 
	     // 等待在 event 上 
	     tester.getEvent().wait(); 
	    } 
	    // 等到 event 后，显示信息 "got event" 
	    Calendar now1 = Calendar.getInstance(); 
	    System.out.println(now1.getTime() + " W " + Thread.currentThread() + " got event.");

	    // do something ... 
	    Thread.sleep(500);

	   } catch (Exception e) { 
	    e.printStackTrace(); 
	   } 
	  } 
	} 
	}