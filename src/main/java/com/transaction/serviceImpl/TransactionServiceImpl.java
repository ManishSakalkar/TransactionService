package com.transaction.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.transaction.entity.Account;
import com.transaction.entity.Transaction;
import com.transaction.repository.TransactionRepository;
import com.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object createTransaction(Integer accountId, Double amount) {
		ResponseEntity<Account> accountResponse = restTemplate.getForEntity("http://ACCOUNT-SERVICE/account/getaccount/"+ accountId, Account.class);
		
		if(accountResponse.getStatusCode() == HttpStatus.OK) {
			Account account = accountResponse.getBody();
			Double currentBalance = account.getCurrentBalance();
			Double newBalance = currentBalance + amount;
			account.setCurrentBalance(newBalance);
			
			restTemplate.put("http://ACCOUNT-SERVICE/account/updateaccount/"+ accountId, account);
			
//			Transaction transaction  = 
			transactionRepo.save(saveCreditTransaction(accountId,amount));
			
			return amount + "Rupees Successfully Credited In Your Account and Your Current Balance is ::" + newBalance;
		}else {
			return "Account Not Found";
		}
		
		
	}

	private Transaction saveCreditTransaction(int accountId, Double amount) {

		Transaction transaction = new Transaction();
		transaction.setAccountId(accountId);

		transaction.setTransactionAmount(amount);
		transaction.setType("Credit");
		transaction.setCreatedTime(LocalDateTime.now());

		return transactionRepo.save(transaction);
	}
	
	

	@Override
	public Object debitTransaction(Integer accountId, Double amount) {
		ResponseEntity<Account> accountResponse = restTemplate
				.getForEntity("http://ACCOUNT-SERVICE/account/getaccount/" + accountId, Account.class);

		if (accountResponse.getStatusCode() == HttpStatus.OK) {
			Account account = accountResponse.getBody();
			Double currentBalance = account.getCurrentBalance();

			if (currentBalance >= amount) {
				Double newBalance = currentBalance - amount;
				account.setCurrentBalance(newBalance);

				restTemplate.put("http://ACCOUNT-SERVICE/account/updateaccount/"+ accountId , account);

//				Transaction transaction = 
				saveDebitTransaction(accountId, amount);
				
				
				return amount +" Rupees Succefully Debited From Your Account And Your Current Balance is ::"+ newBalance;
			} else {
				return "Insufficient balance for account id " + accountId;
			}
		} else {
			return "Account with id " + accountId + " not found";
		}
	}
	
	private Transaction saveDebitTransaction(int accountId, Double amount) {

		Transaction transaction = new Transaction();
		transaction.setAccountId(accountId);

		transaction.setTransactionAmount(amount);
		transaction.setType("Debit");
		transaction.setCreatedTime(LocalDateTime.now());

		return transactionRepo.save(transaction);
	}

	
	@Override
	public Iterable<Transaction> getAllTransaction() {
		
		Iterable<Transaction> alltransaction = transactionRepo.findAll();
		
		return alltransaction;
	}

	@Override
	public Object transferMoney(int sourceAccountId, int destinationAccountId, Double amount) {
		
		ResponseEntity<Account> sourceAccountResponse = restTemplate.getForEntity("http://ACCOUNT-SERVICE/account/getaccount/" + sourceAccountId, Account.class);
        
        if (sourceAccountResponse.getStatusCode() == HttpStatus.OK) {
            Account sourceAccount = sourceAccountResponse.getBody();
            Double sourceBalance = sourceAccount.getCurrentBalance();
            
            if (sourceBalance >= amount) {
                // Debit from source account
                debitTransaction(sourceAccountId, amount);
                
                // Credit to destination account
                createTransaction(destinationAccountId, amount);
                
                return amount + " Rs Transfer successful from accountId: " + sourceAccountId + " to " + destinationAccountId ;
            } else {
                return "Insufficient balance in source account";
            }
        } else {
            return "Source account not found";
        }
    }
}