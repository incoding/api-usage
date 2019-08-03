package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2manydanxiang_code;

import java.io.Serializable;

public class BillDetail implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int					id;
	private String				create_user;
	private String				billid;

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
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
