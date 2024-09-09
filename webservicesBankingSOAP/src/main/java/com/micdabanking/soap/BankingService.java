package com.micdabanking.soap;

public interface BankingService {

	public String getBalance(BankingDto balance);
	
	public String getTransactionInfos(BankingDto transation);
	
	public double getTransactionValue(BankingDto transation);
	
	public String transfertFunds(BankingDto transfert);
}