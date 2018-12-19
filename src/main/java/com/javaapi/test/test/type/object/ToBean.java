package com.javaapi.test.test.type.object;

public class ToBean {
	private String	name;
	private int		age;
	private String	address;
	private String	idno;
	private double	money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	@Override
	public String toString() {
		return "ToBean [name=" + name + ", age=" + age + ", address=" + address
				+ ", idno=" + idno + ", money=" + money + "]";
	}

}