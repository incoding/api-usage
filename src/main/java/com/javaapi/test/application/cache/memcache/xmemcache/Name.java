package com.javaapi.test.application.cache.memcache.xmemcache;

import java.io.Serializable;

public class Name implements Serializable {

	private static final long	serialVersionUID	= -4032296663750081062L;

	String	firstName;
	String	lastName;
	int		age;
	int		money;

	public Name(String firstName, String lastName, int age, int money) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.money = money;
	}

	public String toString() {
		return " [ " + firstName + "   " + lastName + " ,age= " + age
				+ " ,money= " + money + " ] ";
	}

}