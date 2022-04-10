package com.javaapi.test.test.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 这么写会产生额外的匿名内部类，个人感觉没必要
 * 
 */
public class TestInner {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("hello");
				add("world");
			}
		};
		System.out.println(list.toString());
	}
}
