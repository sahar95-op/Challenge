package com.example.AttijariBank.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.AttijariBank.exceptions.InvalidException;
import com.example.AttijariBank.model.Page;
import com.example.AttijariBank.model.Transaction;


public interface TransactionRepository {
	List<Transaction> findAll();

	Transaction findById(Long id);

	List<Transaction> findByAmount(BigDecimal amount);

	List<Transaction> findByMerchant(String merchant);

	List<Transaction> findByStatus(String status);

	Page<Transaction> getPaginatedTransactions(int page, int size);

	Page<Transaction> getPaginatedTransactionsMerchant(int page, int size, String merchant);

	Page<Transaction> getPaginatedTransactionsBYAmount(int page, int size, BigDecimal amount);

	Page<Transaction> getPaginatedTransactionsBYAStatus(int page, int size, String status);

	List<Transaction> getSortedTransactions(String sortBy, String sortOrder) ;

}
