package com.javaapi.test.pattern.concrete.builder;

public class Test {

	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector();
		PersonBuilder pb = new ManBuilder();
		Person person = pd.constructPerson(pb);
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
		System.out.println(person.getHead());
	}
}
