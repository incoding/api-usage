package com.javaapi.test.dao.hibernate.biz.usertype.one2manydanxiang_xml;

import java.io.Serializable;

public class BillDetail implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int					id;
	private String				create_user;
	private String				billid;
	private BillDesc billDesc;
	
	private BankName bankName;

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

	public BillDesc getBillDesc() {
		return billDesc;
	}

	public void setBillDesc(BillDesc billDesc) {
		this.billDesc = billDesc;
	}

	public BankName getBankName() {
		return bankName;
	}

	public void setBankName(BankName bankName) {
		this.bankName = bankName;
	}

}
