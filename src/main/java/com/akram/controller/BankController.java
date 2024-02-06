package com.akram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akram.entity.Bank;
import com.akram.entity.TranscitionsPojo;
import com.akram.entity.TransferPojo;
import com.akram.service.BankService;

@RestController
public class BankController {
	
	
	@Autowired
	private BankService service;

	@PostMapping("/save")
	public String save(@RequestBody Bank bank) {
		
		Bank save=service.addUser(bank);
		String m=null;
		
		if(save!=null) {
			m="account opened successfully";
		}
		else {
			m="account not opened";
		}
		
		return m;
		
	}
	
	
	@GetMapping("/deposit")
	public TranscitionsPojo  deposit(@RequestBody Bank bank) {
		
		
		TranscitionsPojo deposit=service.deposit(bank);
		
		return deposit;
		
	}
	
	@GetMapping("/withdraw")
	public Bank withdraw(@RequestBody Bank bank) {
		
		Bank withdraw = service.withdraw(bank);
		
		return withdraw;
		
	}
	
	
	@GetMapping("/balance/{accountNumber}")
	public Bank balance(@PathVariable int accountNumber) {
		
		Bank balance=service.balance(accountNumber);
		return balance;
	}
	
	
	@GetMapping("/transfer/{accountNumber}/{fromAmount}/{transferAccountNumber}")
	public TransferPojo transfer(@PathVariable int accountNumber,@PathVariable double fromAmount ,@PathVariable int transferAccountNumber) {
		
		TransferPojo transfe=service.transfer(accountNumber,fromAmount,transferAccountNumber);
		
		return transfe;
		
		
		
	}
	
	
	
	
}
