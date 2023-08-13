package com.example.AttijariBank.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AttijariBank.exceptions.InvalidException;

import com.example.AttijariBank.model.Page;
import com.example.AttijariBank.model.Transaction;
import com.example.AttijariBank.service.TransactionService;


@CrossOrigin
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    
    //Tous les transactions sans Pagination
    /*
	 * @GetMapping("/transactions") public List<Transaction> getAllTransactions() {
	 * return transactionService.findAll(); }
	 */
    @GetMapping("/transactions")
    public Page<Transaction> getPaginatedTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return transactionService.getPaginatedTransactions(page, size);
    }
    
    //Filter avec Merchant sans Pagination 

   	/*
   	 * @GetMapping("/transactions/merchant/{merchant}") public List<Transaction>
   	 * getTransactionsByMerchant(@PathVariable String merchant) { return
   	 * transactionService.findByMerchant(merchant); }
   	 */
    @GetMapping("/transactions/merchant/{merchant}")
    public Page<Transaction> getTransactionsByMerchant( @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,@PathVariable String merchant) {
        return transactionService.getPaginatedTransactionsMerchant(page,size,merchant);
    }
    
	

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.findById(id);
    }
    //filter avec Amount sans Pagination
    /*
	 * @GetMapping("/transactions/amount/{amount}") public List<Transaction>
	 * getTransactionsByAmount(@PathVariable BigDecimal amount) { return
	 * transactionService.findByAmount(amount); }
	 */
    @GetMapping("/transactions/amount/{amount}") 
    public Page<Transaction> getTransactionsByAmount(@RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,@PathVariable BigDecimal amount) {
	            		  return transactionService.getPaginatedTransactionsBYAmount(page,size,amount); }
	
    
	//filter avec Status sans Pagination
						/*
						 * @GetMapping("/transactions/status/{status}") public List<Transaction>
						 * getTransactionsByStatus(@PathVariable String status) { return
						 * transactionService.findByStatus(status); }
						 */

    @GetMapping("/transactions/status/{status}") public Page<Transaction> getTransactionsByStatus(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,@PathVariable String status) {
    	return transactionService.getPaginatedTransactionsBYAStatus(page,size,status); }
    
    @GetMapping("/transactions/sort")
    public ResponseEntity<List<Transaction>> getSortedTransactions(
            @RequestParam String sortBy,
            @RequestParam  String sortOrder) {
    	 try {
             List<Transaction> sortedTransactions = transactionService.getSortedTransactions(sortBy, sortOrder);
             System.out.println("ok");
             return ResponseEntity.ok(sortedTransactions);
         } catch ( InvalidException e) {
        	 
             return ResponseEntity.badRequest().body(Collections.emptyList());
         }
     
    }

   
}
