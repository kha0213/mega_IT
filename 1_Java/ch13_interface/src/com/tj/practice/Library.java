package com.tj.practice;

public interface Library {
	public boolean BOOK_STATE_NOMAL = true;
	public boolean BOOK_STATE_BORROWED = false;
	public void bookState();
	public void borrowBook(String bookName, String borrowDate);
	public void returnBook(String bookName, String returnDate);
}
