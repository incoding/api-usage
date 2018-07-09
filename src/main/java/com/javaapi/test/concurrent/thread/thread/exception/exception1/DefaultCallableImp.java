package com.javaapi.test.concurrent.thread.thread.exception.exception1;

import java.util.concurrent.Callable;

public class DefaultCallableImp implements Callable<String> {
private int i;
	public DefaultCallableImp(int i2) {
		this.i=i2;
	}
	@Override
	public String call() throws Exception {
		System.out.println("线程"+i+"执行前");
		if(i==5 || i== 6 || i==7){
			throw new RuntimeException("当线程为"+i+"时候抛出异常");
		}
		System.out.println("线程"+i+"执行后");
		return ""+i;
	}

}
