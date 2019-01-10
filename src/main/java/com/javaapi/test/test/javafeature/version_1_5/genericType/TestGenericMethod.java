package com.javaapi.test.test.javafeature.version_1_5.genericType;

import java.util.List;

/**
 * 泛型方法
 * 
 */
public class TestGenericMethod {
	public <T> void test(T t) {
		System.out.println(t.getClass().getName());
	}
	public static <T>  void copy(List<T> dest, List<? extends T> src){
		//...
		
	}
	public static void main(String[] args) {
		String t = "aa";
		Integer i = 0;
		Object o = new Object();
		new TestGenericMethod().test(t);
		new TestGenericMethod().test(i);
		new TestGenericMethod().test(o);
	}
	
}
