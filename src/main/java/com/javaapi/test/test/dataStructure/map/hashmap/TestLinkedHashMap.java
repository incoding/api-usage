package com.javaapi.test.test.dataStructure.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class TestLinkedHashMap {

	/**LinkedHashMap insertion-ordered
	 * 
	 * 
	 */
	@Test
	public void test() {
		System.out
				.println("*************************LinkedHashMap*************");
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(6, "apple");
		map.put(3, "banana");
		map.put(2, "pear");

		for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			System.out.println(key + "=" + map.get(key));
		}

		System.out.println("*************************HashMap*************");
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(6, "apple");
		map1.put(3, "banana");
		map1.put(2, "pear");

		for (Iterator<Integer> it = map1.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			System.out.println(key + "=" + map1.get(key));
		}
	}

	/**
	 * http://www.cnblogs.com/yejg1212/archive/2013/04/01/2992921.html</br>
	 * 基于访问顺序 accessOrder</br>
	 * accessOrder the ordering mode - true for access-order, false for insertion-order
	 */
	@Test
	public void testaccessOrder() {
		Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f,
				true);
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "e");
		// new add
		map.get("1");
		map.get("2");
		for (Iterator<String> iterator = map.values().iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			System.out.print(name);
		}
	}

	@Test
	public void testForEntry() throws Exception {
		LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
		for (Map.Entry<Object, Object> objectObjectEntry : objectObjectLinkedHashMap.entrySet()) {
			System.out.println("objectObjectEntry = " + objectObjectEntry);
		}
	}
}
