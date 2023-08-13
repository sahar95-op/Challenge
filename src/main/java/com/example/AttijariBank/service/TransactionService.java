package com.example.AttijariBank.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AttijariBank.exceptions.InvalidException;
import com.example.AttijariBank.model.Page;
import com.example.AttijariBank.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionService {
	private List<Transaction> transactions;
	 ObjectMapper mapper = new ObjectMapper();
    public TransactionService() {
    	try {
            InputStream inputStream = getClass().getResourceAsStream("/transactionsMock.json");
            transactions = mapper.readValue(inputStream, new TypeReference<List<Transaction>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    public List<Transaction> findAll() {
    	  try {
              InputStream inputStream = getClass().getResourceAsStream("/transactionsMock.json");
             return transactions = mapper.readValue(inputStream, new TypeReference<List<Transaction>>() {});
          } catch (IOException e) {
              e.printStackTrace();
          }
        return transactions;
    }

    public Transaction findById(Long id) {
        return transactions.stream()
            .filter(transaction -> transaction.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public List<Transaction> findByAmount(BigDecimal amount) {
        return transactions.stream()
            .filter(transaction -> transaction.getAmount().equals(amount))
            .toList();
    }

    public List<Transaction> findByMerchant(String merchant) {
        return transactions.stream()
            .filter(transaction -> transaction.getMerchant().equalsIgnoreCase(merchant))
            .toList();
    }
   
    public List<Transaction> findByStatus(String status) {
        return transactions.stream()
            .filter(transaction -> transaction.getStatus().equalsIgnoreCase(status))
            .toList();
    }
    public Page<Transaction> getPaginatedTransactions(int page, int size) {
        List<Transaction> allTransactions = findAll(); 

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, allTransactions.size());
        List<Transaction> transactionsOnPage = allTransactions.subList(startIndex, endIndex);

        int totalPages = (int) Math.ceil((double) allTransactions.size() / size);
        return new Page<>(transactionsOnPage, page, totalPages, allTransactions.size());
    }

    public Page<Transaction> getPaginatedTransactionsMerchant(int page, int size,String merchant) {
        List<Transaction> allTransactions = findByMerchant(merchant); 

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, allTransactions.size());
        List<Transaction> transactionsOnPage = allTransactions.subList(startIndex, endIndex);

        int totalPages = (int) Math.ceil((double) allTransactions.size() / size);
        return new Page<>(transactionsOnPage, page, totalPages, allTransactions.size());
    }
    public Page<Transaction> getPaginatedTransactionsBYAmount(int page, int size,BigDecimal amount) {
        List<Transaction> allTransactions = findByAmount(amount); 

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, allTransactions.size());
        List<Transaction> transactionsOnPage = allTransactions.subList(startIndex, endIndex);

        int totalPages = (int) Math.ceil((double) allTransactions.size() / size);
        return new Page<>(transactionsOnPage, page, totalPages, allTransactions.size());
    }
    public Page<Transaction> getPaginatedTransactionsBYAStatus(int page, int size,String status) {
        List<Transaction> allTransactions = findByStatus(status); 

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, allTransactions.size());
        List<Transaction> transactionsOnPage = allTransactions.subList(startIndex, endIndex);

        int totalPages = (int) Math.ceil((double) allTransactions.size() / size);
        return new Page<>(transactionsOnPage, page, totalPages, allTransactions.size());
    }
    
    public List<Transaction> getSortedTransactions(String sortBy, String sortOrder) {
        List<Transaction> allTransactions = findAll(); 
        if (!isValidSortProperty(sortBy)) {
            throw new InvalidException("Invalid sort property: " + sortBy);
        }

        if (!isValidSortOrder(sortOrder)) {
            throw new InvalidException("Invalid sort order: " + sortOrder);
        }

        allTransactions.sort((t1, t2) -> {
            int comparisonResult;
            switch (sortBy) {
                case "amount":
                    comparisonResult = t1.getAmount().compareTo(t2.getAmount());
                    break;
                case "merchant":
                    comparisonResult = t1.getMerchant().compareToIgnoreCase(t2.getMerchant());
                    break;
                case "status":
                    comparisonResult = t1.getStatus().compareToIgnoreCase(t2.getStatus());
                    break;
                default:
                    comparisonResult = 0;
            }
            return sortOrder.equals("asc") ? comparisonResult : -comparisonResult;
        });

        return allTransactions;
    }
    private boolean isValidSortProperty(String sortBy) {
        return sortBy.equals("amount") || sortBy.equals("merchant") || sortBy.equals("status");
    }

    private boolean isValidSortOrder(String sortOrder) {
        return sortOrder.equals("asc") || sortOrder.equals("desc");
    }
}
