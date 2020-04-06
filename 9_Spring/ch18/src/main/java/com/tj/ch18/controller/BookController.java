package com.tj.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18.dto.Book;
import com.tj.ch18.service.BookService;
import com.tj.ch18.util.Paging;
// book.do?method=detail
@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	BookService bookService;
	
	
	@RequestMapping(params="method=detail", method = RequestMethod.GET)
	public String detail(Model model,int bnum,String pageNum) {
		model.addAttribute("book",bookService.getBook(bnum));
		model.addAttribute("pageNum",pageNum);
		return "book/detail";
	}
	
	@RequestMapping(params="method=list", method = RequestMethod.GET)
	public String list(Model model,String pageNum,Book book) {
		Paging paging = new Paging(bookService.cntBook(), pageNum, 3, 5);
		model.addAttribute("paging", paging);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		model.addAttribute("list", bookService.bookList(book));
		return "book/list";
	}
}
