package com.banking.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.account.dto.TransactionDto;
import com.banking.account.dto.TransactionResponse;
import com.banking.account.exception.BalanceNotFoundException;
import com.banking.account.exception.TransactionNotFoundException;
import com.banking.account.exception.TransfertNotFoundException;
import com.banking.account.mapper.TransactionMapper;
import com.banking.account.model.Balance;
import com.banking.account.model.Transaction;
import com.banking.account.model.Transfert;
import com.banking.account.repository.BalanceRepository;
import com.banking.account.repository.TransactionRepository;
import com.banking.account.repository.TransfertRepository;
import com.banking.account.service.TransactionService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;
    private final TransfertRepository transfertRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, BalanceRepository balanceRepository, TransfertRepository transfertRepository) {
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
        this.transfertRepository = transfertRepository;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto, int balanceId, int transfertId) {
        Transaction transaction = TransactionMapper.mapToEntity(transactionDto);

        Balance balance = balanceRepository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance could not be found"));
        Transfert transfert = transfertRepository.findById(transfertId).orElseThrow(() -> new TransfertNotFoundException("Transfert could not be found"));

        transaction.setBalance(balance);
        transaction.setTransfert(transfert);

        Transaction newTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToDto(newTransaction);
    }

    @Override
    public TransactionResponse getAllTransaction(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Transaction> transaction = transactionRepository.findAll(pageable);
        List<Transaction> listOfTransaction = transaction.getContent();
        List<TransactionDto> content = listOfTransaction.stream().map(TransactionMapper::mapToDto).collect(Collectors.toList());

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setContent(content);
        transactionResponse.setPageNo(transaction.getNumber());
        transactionResponse.setPageSize(transaction.getSize());
        transactionResponse.setTotalElements(transaction.getTotalElements());
        transactionResponse.setTotalPages(transaction.getTotalPages());
        transactionResponse.setLast(transaction.isLast());

        return transactionResponse;
    }

    @Override
    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction could not be found"));
        return TransactionMapper.mapToDto(transaction);
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto, int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction could not be found"));

        LocalDate date = LocalDate.parse(transactionDto.getDate());

        transaction.setAccountId(transactionDto.getAccountId());
        // reservation.setDate(date);

        Transaction updatedTransaction = transactionRepository.save(transaction);

        return TransactionMapper.mapToDto(updatedTransaction);
    }

    @Override
    public void deleteTransactionById(int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction could not be found"));
        transactionRepository.delete(transaction);
    }

}
