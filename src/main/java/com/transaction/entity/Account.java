package com.transaction.entity;

public class Account {

	private Integer accountid;
	
	private Integer accountNo;
	
	private String accountHolderName;
	
	private String iFSCCode;
	
	private String mobileNumber;
	
	private String address;
	
	private Double currentBalance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accountid, Integer accountNo, String accountHolderName, String iFSCCode, String mobileNumber,
			String address, Double currentBalance) {
		super();
		this.accountid = accountid;
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.iFSCCode = iFSCCode;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.currentBalance = currentBalance;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getiFSCCode() {
		return iFSCCode;
	}

	public void setiFSCCode(String iFSCCode) {
		this.iFSCCode = iFSCCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
}
