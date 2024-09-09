package com.banking.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.account.dto.BalanceDto;
import com.banking.account.dto.BalanceTransactionResponse;
import com.banking.account.dto.BalanceResponse;
import com.banking.account.exception.BalanceNotFoundException;
import com.banking.account.mapper.BalanceMapper;
import com.banking.account.model.Balance;
import com.banking.account.repository.BalanceRepository;
import com.banking.account.service.BalanceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public BalanceDto createBalance(Balance balance) {
        Balance newBalance = balanceRepository.save(balance);
        return BalanceMapper.mapToDto(newBalance);
    }

    @Override
    public BalanceResponse getAllBalance(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Balance> balance = balanceRepository.findAll(pageable);
        List<Balance> listOfBalance = balance.getContent();
        List<BalanceDto> content = listOfBalance.stream().map(BalanceMapper::mapToDto).collect(Collectors.toList());

        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setContent(content);
        balanceResponse.setPageNo(balance.getNumber());
        balanceResponse.setPageSize(balance.getSize());
        balanceResponse.setTotalElements(balance.getTotalElements());
        balanceResponse.setTotalPages(balance.getTotalPages());
        balanceResponse.setLast(balance.isLast());

        return balanceResponse;
    }

    @Override
    public BalanceDto getBalanceById(int id) {
        Balance balance = balanceRepository.findById(id).orElseThrow(() -> new BalanceNotFoundException("Balance could not be found"));
        return BalanceMapper.mapToDto(balance);
    }

    @Override
    public BalanceDto updateBalance(BalanceDto balanceDto, int id) {
        Balance balance = balanceRepository.findById(id).orElseThrow(() -> new BalanceNotFoundException("Balance could not be found"));
        
        balance.setAccountId(balance.getAccountId());
        balance.setAmount(balance.getAmount());
        balance.setCurrency(balance.getCurrency());

        Balance updatedBalance = balanceRepository.save(balance);

        return BalanceMapper.mapToDto(updatedBalance);
    }

    @Override
    public void deleteBalanceById(int id) {
        Balance balance = balanceRepository.findById(id).orElseThrow(() -> new BalanceNotFoundException("Balance could not be found"));
        balanceRepository.delete(balance);
    }

    @Override
    public BalanceTransactionResponse getBalanceTransaction(int id) {
        Balance balance = balanceRepository.findById(id).orElseThrow(() -> new BalanceNotFoundException("Guest could not be found"));
        return BalanceMapper.mapToBalanceTransactionResponse(balance);
    }
}
