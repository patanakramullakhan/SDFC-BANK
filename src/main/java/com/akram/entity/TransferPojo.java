package com.akram.entity;

public class TransferPojo {

	private int accountNumber;
	private String name;
	private double fromAmount;
	private int transferAccountNumber;
	private double transferAmount;
	@Override
	public String toString() {
		return "TransferPojo [accountNumber=" + accountNumber + ", name=" + name + ", fromAmount=" + fromAmount
				+ ", transferAccountNumber=" + transferAccountNumber + ", transferAmount=" + transferAmount + "]";
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
	public double getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public int getTransferAccountNumber() {
		return transferAccountNumber;
	}
	public void setTransferAccountNumber(int transferAccountNumber) {
		this.transferAccountNumber = transferAccountNumber;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	 
	
	
	
	
}
