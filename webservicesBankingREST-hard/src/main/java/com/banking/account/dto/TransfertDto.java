package com.banking.account.dto;

import lombok.Data;

@Data
public class TransfertDto {
    private String accountId;
    private String accountIdRcv;
    private double value;
    private String fee;
    private String currency;
    
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
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
}


  