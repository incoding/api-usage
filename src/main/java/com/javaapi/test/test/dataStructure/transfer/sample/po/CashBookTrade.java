package com.javaapi.test.test.dataStructure.transfer.sample.po;

import java.io.Serializable;

public class CashBookTrade implements Serializable {
    /**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Long id;
    private Long cashBookId;
    private Long inAccountId;
    private Long outAccoutnId;
    private String time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCashBookId() {
		return cashBookId;
	}
	public void setCashBookId(Long cashBookId) {
		this.cashBookId = cashBookId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Long getInAccountId() {
		return inAccountId;
	}
	public void setInAccountId(Long inAccountId) {
		this.inAccountId = inAccountId;
	}
	public Long getOutAccoutnId() {
		return outAccoutnId;
	}
	public void setOutAccoutnId(Long outAccoutnId) {
		this.outAccoutnId = outAccoutnId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CashBookTrade [id=");
		builder.append(id);
		builder.append(", cashBookId=");
		builder.append(cashBookId);
		builder.append(", inAccountId=");
		builder.append(inAccountId);
		builder.append(", outAccoutnId=");
		builder.append(outAccoutnId);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
	
}