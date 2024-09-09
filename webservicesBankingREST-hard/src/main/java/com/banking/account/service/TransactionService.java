package com.banking.account.service;

import com.banking.account.dto.TransactionDto;
import com.banking.account.dto.TransactionResponse;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto Transaction, int balanceId, int transfertId);
    TransactionResponse getAllTransaction(int pageNo, int pageSize);
    TransactionDto getTransactionById(int id);
    TransactionDto updateTransaction(TransactionDto transactionDto, int id);
    void deleteTransactionById(int id);
}
