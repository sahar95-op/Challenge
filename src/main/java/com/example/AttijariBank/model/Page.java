package com.example.AttijariBank.model;

import java.util.List;




public class Page <T>{
	private List<T> content;
    private int pageNumber;
    private int totalPages;
    private long totalElements;
    
	public Page() {
		super();
	}
	public Page(List<T> content, int pageNumber, int totalPages, long totalElements) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
    
    
    
    
}
