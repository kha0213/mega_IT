package com.tj.practice;

public class Book{
	private int bookNo;
	private String bookTitle;
	private String bookWriter;
	private String borrower;
	private boolean bookStatus;
	public Book(int bookNo, String bookTitle, String bookWriter) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		bookStatus = Library.BOOK_STATE_NOMAL;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public boolean isBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	} 
	
	
	


	
	
}
