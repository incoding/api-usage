package com.javaapi.test.test.path;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.unitils.thirdparty.org.apache.commons.io.IOUtils;

public class PathUtil {

	public static void readLog4j() {
		//不写/, 也是相对于类路径下
		InputStream resourceAsStream = PathUtil.class.getClassLoader().getResourceAsStream("log4j.properties");
//		这么写是正确的
		resourceAsStream = PathUtil.class.getResourceAsStream("/log4j.properties");
		//  这么写是错误的
//		 resourceAsStream = PathUtil.class.getResourceAsStream("\\log4j.properties");

		String string = null;
		try {
			string = IOUtils.toString(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(string);
	}
	public static void readLog4jxml() {
		//不写/, 也是相对于类路径下
		String string = null;
		try {
			InputStream resourceAsStream = PathUtil.class.getClassLoader().getResourceAsStream("log4j.xml");
			string = IOUtils.toString(resourceAsStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(string);
	}
	@Test
	public void testName() throws Exception {
		readLog4j();
//		readLog4jxml();
	}
}
