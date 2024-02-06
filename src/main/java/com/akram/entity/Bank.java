package com.akram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_restapi")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;
	private String name;
	private String password;
	private String confirmPassword;
	private double amount;
	private long mobileNumber;
	private String address;
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(int accountNumber, String name, String password, String confirmPassword, double amount,
			long mobileNumber, String address) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.amount = amount;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", amount=" + amount + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + "]";
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
}
