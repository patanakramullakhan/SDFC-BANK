package com.akram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akram.entity.Bank;
import com.akram.entity.TranscitionsPojo;
import com.akram.entity.TransferPojo;
import com.akram.repo.BankRepo;
@Service
public class BankServiceImp implements BankService {
	
	
	@Autowired
	private BankRepo repo;
		

	@Override
	public Bank addUser(Bank bank) {

		Bank s=repo.save(bank);
		return s ;
	}

	

	@Override
	public TranscitionsPojo deposit(Bank bank) {

		Bank oldRecord = repo.findById(bank.getAccountNumber()).get();
		
		if(bank.getAccountNumber()==oldRecord.getAccountNumber() && bank.getName().equalsIgnoreCase(oldRecord.getName()) && bank.getPassword().equalsIgnoreCase(oldRecord.getPassword())) {
			
			double previousAmount = oldRecord.getAmount();
			double currentBalance = previousAmount+bank.getAmount();
			
			oldRecord.setAmount(currentBalance);
			repo.save(oldRecord);
			
			TranscitionsPojo t = new TranscitionsPojo();
			t.setAmount(bank.getAmount());
			t.setCurrentAmount(currentBalance);
			t.setPreviousAmount(previousAmount);
			
			return t;
		}
		else {
			 return null;
		}
		

	}

	@Override
	public Bank withdraw(Bank bank) {
		
		Bank oldRecord = repo.findById(bank.getAccountNumber()).get();
		
		if(bank.getAccountNumber()==oldRecord.getAccountNumber() && bank.getName().equals(oldRecord.getName()) && bank.getPassword().equals(oldRecord.getPassword())) {
			
			double previousBalance = oldRecord.getAmount();
			double currentBalance = previousBalance-bank.getAmount();
			
			
			oldRecord.setAmount(currentBalance);
			Bank with =repo.save(oldRecord);
			
			return with;
			 	
		}

		else {
			return null;
		}
	
	}



	@Override
	public Bank balance(int accountNumber) {

		Bank bal=repo.findById(accountNumber).get();
		
		return bal;
	}



	@Override
	public TransferPojo transfer(int accountNumber,double fromAmount,int transferAccountNumber) {

		Bank fromAct = repo.findById(accountNumber).get();
		Bank toAct = repo.findById(transferAccountNumber).get();
		
		
		if(accountNumber==fromAct.getAccountNumber()) {
			
			double previousFromActBal = fromAct.getAmount();
			double currentFromActBal = previousFromActBal-fromAmount;
			
			fromAct.setAmount(currentFromActBal);
			repo.save(fromAct);
			
			TransferPojo transferPojo = new TransferPojo();
			transferPojo.setAccountNumber(accountNumber);
			transferPojo.setFromAmount(currentFromActBal);
			
	
			
			double previousToActBal = toAct.getAmount();
			double currentToActBal = previousToActBal+fromAmount;
			
			toAct.setAmount(currentToActBal);
			repo.save(toAct);
			
			transferPojo.setTransferAccountNumber(transferAccountNumber);
			transferPojo.setTransferAmount(currentToActBal);
			
			return transferPojo;
			
			
		}
		
		else{
			return null;
		}

	}



	



	

}
