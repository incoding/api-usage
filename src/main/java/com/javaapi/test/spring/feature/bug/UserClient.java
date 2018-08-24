package com.javaapi.test.spring.feature.bug;


public class UserClient {

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	Greeting greeting;

	public void say() {
		System.out.println("----");
		greeting.goodMorning("kk");
	}

}
