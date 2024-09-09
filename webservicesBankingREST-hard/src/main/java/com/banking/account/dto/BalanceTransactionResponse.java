package com.banking.account.dto;

import lombok.Data;

import java.util.List;

@Data
public class BalanceTransactionResponse{
	private String accountId;
    private double amount;;
    private String currency;
    private List<TransactionInfo> transaction;
    
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<TransactionInfo> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<TransactionInfo> transaction) {
		this.transaction = transaction;
	}
    
	 
    
}
