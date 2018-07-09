package com.javaapi.test.application.test.testmockito.tutorials.basedemo2;

public class User {
	private String	id;
private String name;

	public User(String name, String id) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
	return id;
}

	public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

	public String getUserName() {
		return this.name;
	}

	public String getUserId() {
		return this.id;
	}

}
