package com.tj.ex;

public class Paging {
	private int startRow; 
	private int endRow;  
	private int startPage; 
	private int endPage; 
	private int currentPage;
	@Override
	public String toString() {
		return "Paging [startRow=" + startRow + ", endRow=" + endRow + ", startPage=" + startPage + ", endPage="
				+ endPage + ", currentPage=" + currentPage + "]";
	}
	public Paging(int startRow, int endRow, int startPage, int endPage, int currentPage) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
	}
	public Paging() {
		super();
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	} 
	
	
}
