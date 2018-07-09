package com.javaapi.test.test.genericType.testMy;


import static org.junit.Assert.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Client {

	@Test
	public void testName() throws Exception {
		Object o =new Book();
		Book type = getType(o);
		System.err.println(type);
	}
	@Test
	public void testGetTypeList() throws Exception {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		List<Integer> listNew = getTypeList(list);
		for (Integer string : listNew) {
			System.err.println(string);
		}

		List<String> typeList = getTypeList(list);
		System.err.println(typeList);
		//当实际解开来用的时候,如果转成了错误的类型会报错
//		for (String string : typeList) {
//			System.err.println(string);
//		}
	}
	@SuppressWarnings("unchecked")
	public <T> T getType(Object o) {
		return (T) o;
	}
	// todo 传入一个list,返回泛型list
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> getTypeList(List o) {
		return (List<T>) o;
	}
}
