package com.example.AttijariBank.model;

import java.math.BigDecimal;

public class TransactionFilter {
    private BigDecimal amount;
    private String merchant;
    private String status;
	public TransactionFilter(BigDecimal amount, String merchant, String status) {
		super();
		this.amount = amount;
		this.merchant = merchant;
		this.status = status;
	}
	public TransactionFilter() {
		super();
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
    
    
}
