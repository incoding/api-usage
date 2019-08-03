package com.javaapi.test.buisness.dao.hibernate.biz.usertype.one2manydanxiang_xml;

import java.io.Serializable;
import java.util.Set;

public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private int				id;
	private String				billname;
	private Set<BillDetail> billdetails ;
	

	public Set<BillDetail> getBilldetails() {
		return billdetails;
	}

	public void setBilldetails(Set<BillDetail> billdetails) {
		this.billdetails = billdetails;
	}

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
