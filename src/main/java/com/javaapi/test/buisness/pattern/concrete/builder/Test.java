package com.javaapi.test.buisness.pattern.concrete.builder;

/**
 * https://juejin.im/post/5b9bad4be51d450e6f2e2a7b
 * https://springframework.guru/gang-of-four-design-patterns/builder-pattern/
 */
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
