package com.javaapi.test.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Reflect {
	/**
	 * 俩种方式获取类得实例 第一种
	 */
	@Test
	public void gClass() {
		try {
			Class<?> peopleClass = Class
					.forName("com.javaapi.test.test.reflect.People");
			People people = (People) peopleClass.newInstance();
			PrintUtil.print(people);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 俩种方式获取类得实例 第二种
	 */
	@Test
	public void gClassConstruct() {
		try {
			Class<?> peopleClass = Class
					.forName("com.javaapi.test.test.reflect.People");
			People people = (People) peopleClass.getConstructor(String.class)
					.newInstance("nihao");
			System.out.println(people.getName());
			PrintUtil.print(people);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用反射获取所有得方法与获取公共的方法
	 */
	@Test
	public void testDeclareMethod() {
		// 所有得方法,包括公共得私有的等等
		Field[] fileds = People.class.getDeclaredFields();
		for (Field field : fileds) {
			System.out.println(field.getName());
		}
		System.out.println("----------------");
		// 获取公共的方法
		Field[] fileds2 = People.class.getFields();
		for (Field field : fileds2) {
			System.out.println(field.getName());
		}
	}
}
