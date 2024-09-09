package com.banking.account.service;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.BalanceTransactionResponse;
import com.banking.account.dto.BalanceResponse;
import com.banking.account.model.Balance;

public interface BalanceService {
    BalanceDto createBalance(Balance balance);
    BalanceResponse getAllBalance(int pageNo, int pageSize);
    BalanceDto getBalanceById(int id);
    BalanceDto updateBalance(BalanceDto balanceDto, int id);
    void deleteBalanceById(int id);
    BalanceTransactionResponse getBalanceTransaction(int id);
    
}
