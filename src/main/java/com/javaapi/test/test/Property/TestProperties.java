package com.javaapi.test.test.Property;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * 中文写进去,虽然看properties文件中是乱码,但是程序读出来不是.</br>
 * 所以处理properties 乱码.  先读取下看是不是乱码,如果不是乱码.</br>
 找个编辑器插件,在eclipse,properties文件中能查看中文就可以</br>
 * http://jingyan.baidu.com/article/ed2a5d1f3381d709f6be17f8.html</br>
 * 
 */
public final class TestProperties {
	@Test
	public void testProperties() throws Exception {
		InputStream resourceAsStream = TestProperties.class.getResourceAsStream("testProp.properties");
		Properties p = new Properties();
		p.load(resourceAsStream);
		System.out.println(p);
		p.getProperty("spname");
		System.out.println(p.getProperty("spname"));
	}

}