package com.tj.ch18.dao;

import java.util.List;

import com.tj.ch18.dto.Book;

public interface BookDao {
	public List<Book> mainList();
	public int cntBook();
	public int registerBook(Book book);
	public int modifyBook(Book book);
	List<Book> bookList(Book book);
	Book getBook(int bnum);
	
}
