package com.banking.account.dto;

import lombok.Data;

import java.util.Date;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.TransfertDto;

@Data
public class TransactionDto {
    private String accountId;
    private String accountIdRcv;
    private double value;
    private String currency;
	private String date;
    private TransfertDto transfert;
    private BalanceDto balance;
    
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountIdRcv() {
		return accountIdRcv;
	}
	public void setAccountIdRcv(String accountIdRcv) {
		this.accountIdRcv = accountIdRcv;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
	public TransfertDto gettransfert() {
		return transfert;
	}
	public void setTransfert(TransfertDto Transfert) {
		this.transfert = Transfert;
	}
	public BalanceDto getBalance() {
		return balance;
	}
	public void setBalance(BalanceDto Balance) {
		this.balance = Balance;
	}
    
}
