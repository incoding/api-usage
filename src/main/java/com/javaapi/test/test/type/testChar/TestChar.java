package com.javaapi.test.test.type.testChar;

import org.junit.Test;

public class TestChar {
	@Test
	public void testChar() throws Exception {
		char a = (char) -100;
		System.out.println((int)a);
	}
	/**
	 * 数据类型	byte	short	char	int		long	float	double	boolean
	 	占用字节数	1		2		2		4		8		4		8		1
	 */
	@Test
	public void testChinaChar() throws Exception {
		char a = '你';
		System.out.println(a);
	}
}
