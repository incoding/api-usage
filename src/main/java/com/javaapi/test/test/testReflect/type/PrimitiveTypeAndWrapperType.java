package com.javaapi.test.test.testReflect.type;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypeAndWrapperType {
	public String name = "wk";
	public int primitiveAge = 1;
	public Integer wrapperAge = 2;
	public List<String> listType = new ArrayList<String>();

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException {
		PrimitiveTypeAndWrapperType test = new PrimitiveTypeAndWrapperType();
		Class a = PrimitiveTypeAndWrapperType.class;
		Field primitiveAge = a.getField("primitiveAge");
		Field wrapperAge = a.getField("wrapperAge");
		Field listType = a.getField("listType");
		System.out.println(primitiveAge.getClass());
		System.out.println(primitiveAge.getDeclaringClass());
		System.out.println(primitiveAge.getGenericType());
		System.out.println(primitiveAge.getType());
		System.out.println("----------");
		System.out.println(wrapperAge.getClass());
		System.out.println(wrapperAge.getDeclaringClass());
		System.out.println(wrapperAge.getGenericType());
		System.out.println(wrapperAge.getType());
		System.out.println("----------");
		System.out.println(listType.getClass());
		System.out.println(listType.getDeclaringClass());
		System.out.println(listType.getGenericType());
		System.out.println(listType.getType());
		System.out.println("----------");
		System.out.println(primitiveAge.getType() == int.class);
		System.out.println(primitiveAge.getType() == Integer.class);
		System.out.println(primitiveAge.getType() == Integer.TYPE);
		System.out.println("----------");
		System.out.println(wrapperAge.getType() == int.class);
		System.out.println(wrapperAge.getType() == Integer.class);
		System.out.println(wrapperAge.getType() == Integer.TYPE);
		System.out.println("----------------");
		System.out.println(int.class == Integer.TYPE);
	}
}