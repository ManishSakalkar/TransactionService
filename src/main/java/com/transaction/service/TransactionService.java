package com.transaction.service;

import com.transaction.entity.Transaction;

public interface TransactionService {
	
	Object createTransaction(Integer accountId, Double amount);
	
	public Object debitTransaction(Integer accountId, Double amount);
	
	public Iterable<Transaction> getAllTransaction();
	
	Object transferMoney(int sourceAccountId, int destinationAccountId, Double amount);
}
