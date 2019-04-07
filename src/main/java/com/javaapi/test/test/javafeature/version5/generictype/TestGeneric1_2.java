package com.javaapi.test.test.javafeature.version5.generictype;

import java.util.ArrayList;
import java.util.Collection;

public class TestGeneric1_2<T extends Number> {
	//1 这么写会报错
//	public  Generic3<T> g = new Generic3<T>();
	public static void main(String[] args) {
		Collection<String> cs = new ArrayList<String>();
		Collection<Collection<String>> ls = new ArrayList<Collection<String>>();
		if (cs instanceof Collection<?>) {
			System.out.println("yes");
		} 
		if (ls instanceof Collection<?>) {
			System.out.println("yes");
		} 
	}

}
