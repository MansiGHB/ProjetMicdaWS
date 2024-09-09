package com.banking.account.mapper;

import lombok.NoArgsConstructor;

import java.util.List;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.BalanceTransactionResponse;
import com.banking.account.dto.TransactionInfo;
import com.banking.account.model.Balance;

@NoArgsConstructor
public class BalanceMapper {
    public static BalanceDto mapToDto(Balance balance){
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.setAccountId(balance.getAccountId());
        balanceDto.setAmount(balance.getAmount());
        balanceDto.setCurrency(balance.getCurrency());
        return balanceDto;
    }

    public static BalanceTransactionResponse mapToBalanceTransactionResponse(Balance balance){
        BalanceTransactionResponse balanceTransactionResponse = new BalanceTransactionResponse();

        List<TransactionInfo> transctionInfo = TransactionMapper.mapElementsToTransactionInfo(balance.getTransaction());

        balanceTransactionResponse.setAccountId(balance.getAccountId());
        balanceTransactionResponse.setAmount(balance.getAmount());
        balanceTransactionResponse.setCurrency(balance.getCurrency());
        balanceTransactionResponse.setTransaction(transctionInfo);
        return balanceTransactionResponse;
    }
}
