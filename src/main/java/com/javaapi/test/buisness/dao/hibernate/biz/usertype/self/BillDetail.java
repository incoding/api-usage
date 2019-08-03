package com.javaapi.test.buisness.dao.hibernate.biz.usertype.self;

import java.io.Serializable;

public class BillDetail implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int				id;
	private String				create_user;
	private OrganType billid;


	public OrganType getBillid() {
		return billid;
	}

	public void setBillid(OrganType billid) {
		this.billid = billid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

}
