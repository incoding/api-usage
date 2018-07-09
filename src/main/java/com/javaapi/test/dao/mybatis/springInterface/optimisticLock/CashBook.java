package com.javaapi.test.dao.mybatis.springInterface.optimisticLock;

import java.io.Serializable;
import java.math.BigDecimal;

public class CashBook implements Serializable {
    private Long id;
    private Long accountId;
    private BigDecimal balance;
    private BigDecimal version;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CashBook [id=");
		builder.append(id);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

}