package com.javaapi.test.test.dataStructure.transfer.sample.po;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private Long				id;
	private String				name;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
