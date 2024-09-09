package com.micdabanking.soap;

public class BankingServiceImpl implements BankingService {

	@Override
	public String getBalance(BankingDto balance) {
		return balance.getAccountId();
	}

	@Override
	public String getTransactionInfos(BankingDto transaction) {
		return transaction.getAccountId();
	}
	
	@Override
	public double getTransactionValue(BankingDto transaction) {
		return transaction.getValue();
	}
		
	@Override
	public String transfertFunds(BankingDto transfert) {
		return transfert.getAccountId();
	}

}
