package com.javaapi.test.buisness.dao.hibernate.biz.dynamic;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int				id;
	private String				billname;
	private String billfirstname;
	private String  billlastname;

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

	public String getBillfirstname() {
		return billfirstname;
	}

	public void setBillfirstname(String billfirstname) {
		this.billfirstname = billfirstname;
	}

	public String getBilllastname() {
		return billlastname;
	}

	public void setBilllastname(String billlastname) {
		this.billlastname = billlastname;
	}

}
