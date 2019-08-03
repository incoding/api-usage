package com.javaapi.test.buisness.dao.mybatis.springInterface.domain;

public class Bill {
	
	private Long id;
	private Long billid;
	private String create_user;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the billid
	 */
	public Long getBillid() {
		return billid;
	}


	/**
	 * @param billid the billid to set
	 */
	public void setBillid(Long billid) {
		this.billid = billid;
	}


	/**
	 * @return the create_user
	 */
	public String getCreate_user() {
		return create_user;
	}


	/**
	 * @param create_user the create_user to set
	 */
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bill [id=");
		builder.append(id);
		builder.append(", billid=");
		builder.append(billid);
		builder.append(", create_user=");
		builder.append(create_user);
		builder.append("]");
		return builder.toString();
	}
	
	

}
