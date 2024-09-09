package com.banking.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accountId;
    @Column(name = "balance")
    private double amount;
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


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getTransction() {
		return transaction;
	}

	public void setTransction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	private String currency;

    @OneToMany(mappedBy = "balance",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Transaction> transaction = new ArrayList<>();
    
    public List<Transaction> getTransaction() {
		return transaction;
	}
}



