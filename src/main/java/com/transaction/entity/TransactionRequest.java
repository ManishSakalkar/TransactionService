package com.transaction.entity;

public class TransactionRequest {
	
	private int accountId;
	private Double transactionAmount;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public TransactionRequest(int accountId, Double transactionAmount) {
		super();
		this.accountId = accountId;
		this.transactionAmount = transactionAmount;
	}
	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
