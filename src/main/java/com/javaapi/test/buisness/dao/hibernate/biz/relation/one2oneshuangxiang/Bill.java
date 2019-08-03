package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2oneshuangxiang;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private String				id;
	private String				billname;
	private BillDetail			billdetail;
	
	public BillDetail getBilldetail() {
		return billdetail;
	}

	public void setBilldetail(BillDetail billdetail) {
		this.billdetail = billdetail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillname() {
		return billname;
	}

	public void setBillname(String billname) {
		this.billname = billname;
	}

}
