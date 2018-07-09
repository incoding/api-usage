package com.javaapi.test.test.testType.object;

public class DiffBean {
	private String	name_tmp;
	private int		age_tmp;
	private String	address;
	private String	idno_tmp;
	private double	money_tmp;
	public String getName_tmp() {
		return name_tmp;
	}
	public void setName_tmp(String name_tmp) {
		this.name_tmp = name_tmp;
	}
	public int getAge_tmp() {
		return age_tmp;
	}
	public void setAge_tmp(int age_tmp) {
		this.age_tmp = age_tmp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdno_tmp() {
		return idno_tmp;
	}
	public void setIdno_tmp(String idno_tmp) {
		this.idno_tmp = idno_tmp;
	}
	public double getMoney_tmp() {
		return money_tmp;
	}
	public void setMoney_tmp(double money_tmp) {
		this.money_tmp = money_tmp;
	}
	@Override
	public String toString() {
		return "DiffBean [name_tmp=" + name_tmp + ", age_tmp=" + age_tmp
				+ ", address=" + address + ", idno_tmp=" + idno_tmp
				+ ", money_tmp=" + money_tmp + "]";
	}

}