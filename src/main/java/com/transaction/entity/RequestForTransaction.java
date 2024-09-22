package com.transaction.entity;

public class RequestForTransaction {
	
	private Integer accountId;
	
	private Double amount;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RequestForTransaction(Integer accountId, Double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}

	public RequestForTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
