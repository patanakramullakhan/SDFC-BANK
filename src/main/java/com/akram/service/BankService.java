package com.akram.service;

import com.akram.entity.Bank;
import com.akram.entity.TranscitionsPojo;
import com.akram.entity.TransferPojo;


public interface BankService {

	public Bank addUser(Bank bank);
	public Bank balance(int accountNumber);
	public TranscitionsPojo deposit(Bank bank);
	public Bank withdraw(Bank bank);
	public TransferPojo transfer(int accountNumber,double fromAmount,int transferAccountNumber);
	
	
}
