package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2oneshuangxiang_annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="bill")
public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int				id;
	@Column(name="billname")
	private String				billname;
	
	@OneToOne(mappedBy="bill")
	private BillDetail billdetail;


	public BillDetail getBilldetail() {
		return billdetail;
	}

	public void setBilldetail(BillDetail billdetail) {
		this.billdetail = billdetail;
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
