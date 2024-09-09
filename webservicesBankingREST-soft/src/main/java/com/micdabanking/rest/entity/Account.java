package com.micdabanking.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private String accountId;
	private double amount;
	private String currency;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(double amount, String accountId, String currency) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.currency = currency;
	}


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

	@Override
	public String toString() {
		return "Account [ID=" + accountId + ", Amount =" + amount + currency + "]";
	}

}