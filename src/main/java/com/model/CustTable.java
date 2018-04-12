package com.model;

import java.util.Date;

public class CustTable {
	private String custAccount;
	private String custName;
	private Float creditLimit;
	private Date createdDate;
	public String getCustAccount() {
		return custAccount;
	}
	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Float getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
