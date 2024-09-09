package com.banking.account.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.TransactionDto;
import com.banking.account.dto.TransactionInfo;
import com.banking.account.dto.TransfertDto;
import com.banking.account.model.Transaction;

public class TransactionMapper {
    public static TransactionDto mapToDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        BalanceDto balanceDto = BalanceMapper.mapToDto(transaction.getBalance());
        TransfertDto transfertDto = TransfertMapper.mapToDto(transaction.getTransfert());

        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.setAccountIdRcv(transaction.getAccountIdRcv());
        transactionDto.setValue(transaction.getValue());
        transactionDto.setCurrency(transaction.getCurrency().toString());
        transactionDto.setDate(transaction.getDate().toString());
        transactionDto.setBalance(balanceDto);
        transactionDto.setTransfert(transfertDto);

        return transactionDto;
    }

    public static Transaction mapToEntity(TransactionDto transactionDto){
        Transaction transaction = new Transaction();

        LocalDate date = LocalDate.parse(transactionDto.getDate());

        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setAccountIdRcv(transactionDto.getAccountIdRcv());
        transaction.setValue(transaction.getValue());
        transaction.setCurrency(transaction.getCurrency());
        transaction.setDate(transaction.getDate().toString());
        return transaction;
    }

    public static TransactionInfo mapToTransactionInfo(Transaction transaction){
        TransactionInfo transactionInfo = new TransactionInfo();

        TransfertDto transfertDto = TransfertMapper.mapToDto(transaction.getTransfert());

        transactionInfo.setAccountId(transaction.getAccountId());
        transactionInfo.setAccountIdRcv(transaction.getAccountIdRcv());
        transactionInfo.setValue(transaction.getValue());
        transactionInfo.setCurrency(transaction.getCurrency());
        transactionInfo.setDate(transaction.getDate().toString());
        transactionInfo.setTransfert(transfertDto);

        return transactionInfo;
    }

    public static List<TransactionInfo> mapElementsToTransactionInfo(List<Transaction> transactionList){
        return transactionList.stream().map((TransactionMapper::mapToTransactionInfo)).collect(Collectors.toList());
    }
}
