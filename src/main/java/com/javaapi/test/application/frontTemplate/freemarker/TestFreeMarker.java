package com.javaapi.test.application.frontTemplate.freemarker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestFreeMarker {
	/**
	 * mapInner只能为number, sequence, or string.
	 */
	@Test
	public void testMapString() {
		String freemarkerName = "testmap.ftl";
		String freemarkerHtml = "testmap.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> mapInner = new HashMap<String, Integer>();
		mapInner.put("number1", 1);
		mapInner.put("number2", 2);
		mapInner.put("number3", 3);
		map.put("mapInner", mapInner);
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
		// 输出到path变量
	}

	/**
	 * mapInner只能为number, sequence, or string. </br>TODO 其他?
	 */
	@Test
	public void testMapInteger() {
		String freemarkerName = "testmapinteger.ftl";
		String freemarkerHtml = "testmapinteger.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<Integer, Integer> mapInner = new HashMap<Integer, Integer>();
		mapInner.put(1, 1);
		mapInner.put(2, 2);
		mapInner.put(3, 3);
		Map<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer, Integer>>();
		map.put("mapInner", mapInner);
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
		// 输出到path变量
	}

	@Test
	public void testList() {
		String freemarkerName = "testlist.ftl";
		String freemarkerHtml = "testlist.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		list.add("nihao1");
		list.add("nihao2");
		list.add("nihao3");
		map.put("nihaolist", list);
		// 输出到path变量
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
	}


	@Test
	public void testToString() {
		String freemarkerName = "testToString.ftl";
		String freemarkerHtml = "testToString.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number2", 20000);
		map.put("foo1", true);
		map.put("foo2", false);
		// 输出到path变量
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
	}

	/**
	 * freemarker里面得判断,只跟实际类型有关.跟声明得泛型物管</br> Map<Object, Object> map = new
	 * HashMap<Object, Object>(); </br> Map<String, Object> map = new
	 * HashMap<String, Object>();
	 */
	@Test
	public void testIf() {
		String freemarkerName = "testIf.ftl";
		String freemarkerHtml = "testIf.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("number2", 2);
		map.put("number3", "3");
		map.put("booleanTrue", true);
		map.put("booleanFalse", false);
		Map<Object, Object> mapInner = new HashMap<>();
		mapInner.put("booleanTrue", true);
		mapInner.put("booleanFalse", false);
		map.put("mapInner", mapInner);
		// 输出到path变量
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
	}
    @Test
    public void testIf_V2() {
        String freemarkerName = "testIf.ftl";
        String freemarkerHtml = "testIf.shtml";
        String path2 = TestFreeMarker.class.getResource("").getPath();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("number2", 2);
        map.put("number3", "3");
        map.put("booleanTrue", true);
        map.put("booleanFalse", false);
        Map<Object, Object> mapInner = new HashMap<>();
//        mapInner.put("booleanTrue", true);
        mapInner.put("booleanTrue", Boolean.TRUE);

        mapInner.put("booleanFalse", false);
        map.put("mapInner", mapInner);
        // 输出到path变量
        FreeMarkerUtil.geneHtmlFileToString(freemarkerName, map, path2, freemarkerHtml);
    }

	// TODO 1 属性值存在得时候 2 map值是否存在

	@Test
    public void testExists() {
        String freemarkerName = "testif.ftl";
        String freemarkerHtml = "testif.shtml";
        String path2 = TestFreeMarker.class.getResource("").getPath();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("number2", 2);
        map.put("number3", "3");
        map.put("booleanTrue", true);
        map.put("booleanFalse", false);
        Map<Object, Object> mapInner = new HashMap<>();
        mapInner.put("booleanTrue", true);
        mapInner.put("booleanFalse", false);
        map.put("mapInner", mapInner);
        // 输出到path变量
        FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
    }
	//TODO 检验非空
	@Test
	public void testNull() {
		String freemarkerName = "testnull.ftl";
		String freemarkerHtml = "testnull.shtml";
		String path2 = TestFreeMarker.class.getResource("").getPath();
		Map<Object, Object> map = new HashMap<Object, Object>();
		FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
	}
}
