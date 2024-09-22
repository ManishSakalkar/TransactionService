package com.transaction.entity;

public class TransferRequest {
	private int sourceAccountId;
    private int destinationAccountId;
    private Double amount;
    
	public TransferRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransferRequest(int sourceAccountId, int destinationAccountId, Double amount) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
	}
	
	public int getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public int getDestinationAccountId() {
		return destinationAccountId;
	}
	public void setDestinationAccountId(int destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
