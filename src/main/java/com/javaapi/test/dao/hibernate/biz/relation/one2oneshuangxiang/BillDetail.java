package com.javaapi.test.dao.hibernate.biz.relation.one2oneshuangxiang;

import java.io.Serializable;

public class BillDetail implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private String				id;
	private String				create_user;
	private Bill bill;
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

}
