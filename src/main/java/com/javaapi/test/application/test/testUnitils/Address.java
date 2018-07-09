package com.javaapi.test.application.test.testUnitils;

public class Address {
	private String	street;
	private int		number;
	private String	building;

	public Address(String street, int number, String building) {
		super();
		this.street = street;
		this.number = number;
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

}
