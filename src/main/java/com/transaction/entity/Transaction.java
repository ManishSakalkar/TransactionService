package com.transaction.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Transaction {
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer transactionId, Integer accountId, Double transactionAmount, LocalDateTime createdTime,
			String type, Integer sourceAccountId, Integer destinationAccountId) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionAmount = transactionAmount;
		this.createdTime = createdTime;
		this.type = type;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(Integer sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public Integer getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(Integer destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private Integer accountId;
	
	private Double transactionAmount;
	
	private LocalDateTime createdTime;
	
	private String type;
	
	private Integer sourceAccountId;
	
	private Integer destinationAccountId;

	
	
	
	
}
