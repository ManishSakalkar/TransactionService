package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.entity.Transaction;
import com.transaction.entity.TransactionRequest;
import com.transaction.entity.TransferRequest;
import com.transaction.serviceImpl.TransactionServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionService ;

    
	
	@PostMapping("/credit")
	public ResponseEntity<Object> creditAmount(@RequestBody TransactionRequest transactionRequest ) {
		int accId = transactionRequest.getAccountId();
		Double amouountToCredit = transactionRequest.getTransactionAmount();
		
		Object transaction = transactionService.createTransaction(accId, amouountToCredit);
		
		return ResponseEntity.status(HttpStatus.OK).body(transaction);
	}
	
	
	@PostMapping("/debit")
	public ResponseEntity<Object> debitTransaction(@RequestBody TransactionRequest transactionRequest ) {
		int accountId = transactionRequest.getAccountId();
		Double amouountToDebited = transactionRequest.getTransactionAmount();
		Object transaction = transactionService.debitTransaction(accountId, amouountToDebited);
		return ResponseEntity.ok(transaction);
	}
	
	@GetMapping("/alltransaction")
	public ResponseEntity<Iterable<Transaction>> allTransaction()
	{
		
		
		Iterable<Transaction> result = transactionService.getAllTransaction();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
		
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<Object> transferMoney(@RequestBody TransferRequest transferRequest) {
	    
		int sourceAccountId = transferRequest.getSourceAccountId();
	    int destinationAccountId = transferRequest.getDestinationAccountId();
	    Double amount = transferRequest.getAmount();
	    
	    // Perform validation if necessary
	    
	    Object transferResult = transactionService.transferMoney(sourceAccountId, destinationAccountId, amount);
	    
	    return ResponseEntity.ok(transferResult);
	}
	

}
