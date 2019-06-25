package com.javaapi.test.test.type.String.testString.behavior;

public class TestInit {
	// 赋值为null了，就不可以在static再赋值了
//	public static final String string  = null;
	public static final String string ;
	
	static {
		string="aaa";
	}
	
	public static void main(String[] args) {
		System.out.println(string);
	}
}
