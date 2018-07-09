package com.javaapi.test.testUtil.opensource.guava.maps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;




public class Client {

	/**
	 * multiMap实现一对多</br>,多得一方最好是同一类型
	 * 　我已经数不清我有多少次需要在一个Map中实现一个key对应多个value的需求</br>
	 */
	@Test
	public void testMultiMap() throws Exception {
		Multimap<Integer, String> multimap = ArrayListMultimap.create();
		multimap.put(1, "a");
		multimap.put(1, "b");
		System.err.println(multimap.get(1));
		multimap.put(2, "c");
		multimap.put(2, "d");
		System.err.println(multimap.get(1));
		List<String> list =new ArrayList<>(multimap.get(1));
		System.err.println(list);
		System.err.println(list);
		List<String> tmp = (List<String>) multimap.get(1);
		System.err.println(tmp);
	}
}
