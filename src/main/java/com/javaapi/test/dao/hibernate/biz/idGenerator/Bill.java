package com.javaapi.test.dao.hibernate.biz.idGenerator;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int				id;
	private String				billname;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillname() {
		return billname;
	}

	public void setBillname(String billname) {
		this.billname = billname;
	}

}
