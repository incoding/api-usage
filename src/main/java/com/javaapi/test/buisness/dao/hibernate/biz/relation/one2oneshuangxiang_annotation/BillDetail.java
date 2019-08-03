package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2oneshuangxiang_annotation;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billdetail")
public class BillDetail implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int					id;
	@Column(name = "create_user")
	private String				create_user;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "billid")
	private Bill				bill;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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
