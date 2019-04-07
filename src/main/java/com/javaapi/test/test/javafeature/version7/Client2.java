package com.javaapi.test.test.javafeature.version7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Client2 {
	
	@Test
	public void test() {
		long currentTimeMillis = System.currentTimeMillis();
		List<Map<String, String>> hashMap = getHashMap();
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
		currentTimeMillis = System.currentTimeMillis();
		int i=0;
		for (Map<String, String> map : hashMap) {
			map.get(String.valueOf(i));
			i++;
		}
		 currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
	}

	private List<Map<String,String>> getHashMap() {
		List<Map<String,String>> list = new ArrayList<>();
		int j = 1000000;
		for (int i = 0; i < j; i++) {
			Map<String,String>	map =new HashMap<>();
			map.put(String.valueOf(i), String.valueOf(i));
			list.add(map);
		}
		return list;
	}
}
