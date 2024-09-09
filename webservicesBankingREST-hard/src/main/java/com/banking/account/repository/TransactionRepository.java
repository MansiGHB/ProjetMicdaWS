package com.banking.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
