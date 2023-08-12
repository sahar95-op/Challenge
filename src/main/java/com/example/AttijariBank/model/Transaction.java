package com.example.AttijariBank.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Long id;
    private BigDecimal amount;
    private String merchant;
    private String status;
    private Date date;
    
    
    
	public Transaction() {
		super();
	}
	public Transaction(Long id, BigDecimal amount, String merchant, String status, Date date) {
		super();
		this.id = id;
		this.amount = amount;
		this.merchant = merchant;
		this.status = status;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
    
	
}
