package com.javaapi.test.pattern.action.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 有点像是递归
 *
 */
public class Client {
	
	@Test
	public void test(){
		ActionInvocation actionInvocation = new ActionInvocation();
		Action action = new Action();
		List<Interceptor> list =new ArrayList<>();
		list.add(new LogInterceptor());
		list.add(new LogInterceptor());
		list.add(new LogInterceptor());
		actionInvocation.setAction(action);
		actionInvocation.setIterator(list.iterator());
		Object invoke = actionInvocation.invoke();
		if(invoke instanceof String){
			String aa = (String) invoke;
			System.out.println(aa);
		}
	}

}
