package com.javaapi.test.buisness.pattern.concrete.clone;

public class A implements Cloneable {
	public String name;

	public Object clone() {
		A o = null;
		try {
			o = (A) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

}
