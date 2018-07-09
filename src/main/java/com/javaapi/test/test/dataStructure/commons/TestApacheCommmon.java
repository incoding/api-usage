package com.javaapi.test.test.dataStructure.commons;

import java.util.HashMap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestApacheCommmon {
	/**
	 * maputils 测试默认值
	 */
	@Test
	public void MapUtils() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 1);
		map.put("c", 1);
		System.out.println(MapUtils.getInteger(map, "c", 12));
		System.out.println(MapUtils.getInteger(map, "d", 12));
	}

	/**
	 * MultiValueMap 实现1对多
	 */
	@Test
	public void MuitiMap() {
		MultiValueMap<String, Integer> map = new MultiValueMap<String, Integer>();
		map.put("a", 11);
		map.put("a", 12);
		map.put("b", 13);
		map.put("b", 14);
		System.out.println(map.getCollection("a"));
	}

	/**
	 * 通过俩个hash实现的DualHashBidiMap
	 */
	@Test
	public void biDiMap() {
		System.out.println(StringUtils.center(" demoBidiMap ", 40, "="));
		BidiMap<String, String> bidiMap = new DualHashBidiMap<String, String>();
		bidiMap.put("BJ", "Beijing");
		bidiMap.put("SH", "Shanghai");
		bidiMap.put("GZ", "Guangzhou");
		bidiMap.put("CD", "Chengdu");
		System.out.println("Key-Value: BJ = " + bidiMap.get("BJ"));
		System.out.println("Value-Key: Chengdu = " + bidiMap.getKey("Chengdu"));
		System.out.println(StringUtils.repeat("=", 40));
	}
}
