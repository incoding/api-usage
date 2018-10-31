package com.javaapi.test.arithmetic.recursion.node2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Client2 {
	
	@Test
	public void testName() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("5", 1);
		map.put("5", 2);
		map.put("5", 3);
		map.put("5", 6);

		map.put("6", 7);
		map.put("7", 8);
		handleMap("5", map);
	}

	private void handleMap(String wei, Map<String, Integer> src) {
		Integer _wei = src.get(wei);
		if (_wei != null) {
			Integer iwei = Integer.valueOf(wei);
			if (_wei.intValue() >= 5) {
				src.put(String.valueOf(iwei - 1),
						src.get(String.valueOf(iwei - 1)) + 1);
				src.put(wei, _wei.intValue() - 5);
				handleMap(wei, src);
				System.out.println(src);
			} else if (_wei.intValue() < 0) {
				src.put(String.valueOf(iwei - 1),
						src.get(String.valueOf(iwei - 1)) - 1);
				src.put(wei, _wei.intValue() + 5);
				handleMap(wei, src);
				System.out.println(src);
			}
		}
	}

}
