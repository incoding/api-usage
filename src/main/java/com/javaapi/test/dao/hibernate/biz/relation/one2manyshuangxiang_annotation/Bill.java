package com.javaapi.test.dao.hibernate.biz.relation.one2manyshuangxiang_annotation;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int					id;
	@Column(name = "billname")
	private String				billname;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="bill")
	private Set<BillDetail>		billdetails;

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
