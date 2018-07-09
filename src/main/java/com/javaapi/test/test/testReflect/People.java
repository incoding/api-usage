package com.javaapi.test.test.testReflect;

enum Sex {
	MALE, FEMALE
}

public class People {
	public int id = 1;
	public String name = "zhang san";
	public Sex sex = Sex.MALE;
	public String[] friends = { "李四", "王五" };
	private String phone="12345678901";
	private String address="XXX";
	public People(String name) {
		super();
		this.name = name;
	}

	public People() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String[] getFriends() {
		return friends;
	}

	public void setFriends(String[] friends) {
		this.friends = friends;
	}

}