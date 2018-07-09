package com.javaapi.test.test.dataStructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EqualsAndHash {

	@Test
	public void test() {
		String aa = "sss";
		String bb = "sss";
		String cc = "ssss";
		System.out.println(aa.equals(bb));
		System.out.println(aa.hashCode());
		System.out.println(bb.hashCode());
		System.out.println(cc.hashCode());
		System.out.println("---------------------");
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

	@Test
	public void testHash() {
		List<String> list = new ArrayList<String>();
		list.add("你好");
		list.add("你好2");
		list.add("你好sdfdsf");
		List<String> list2 = new ArrayList<String>();
		list2.add("你好");
		list2.add("你好");
		System.out.println(list.containsAll(list2));

	}

	@Test
	public void testHash2() {
		List<String> list = new ArrayList<String>();
		list.add("你好");
		list.add("你好2");
		list.add("你好sdfdsf");
		List<String> list2 = new ArrayList<String>();
		list2.add("你好");
		list2.add("你好3");// 注意 这样返回false
		System.out.println(list.containsAll(list2));
	}
}
