package com.tj.ex5_library;

public class BookInfo {
	private String bookNo;
	private String bookTitle;
	private String writer;

	public BookInfo() {
	}

	public BookInfo(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	
}
