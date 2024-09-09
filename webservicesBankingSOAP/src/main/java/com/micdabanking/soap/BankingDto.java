package com.micdabanking.soap;

public class BankingDto {
	
	private String accountId;
    private double amount;;
    private String currency;
    
    private String accountIdRcv;
    private double value;
    private String fee;
	private String date;

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
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Balance [account=" + accountId + ", amount=" + amount + currency +"]";
	}
		
}