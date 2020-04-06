package com.tj.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18.dto.Book;
import com.tj.ch18.service.BookService;
import com.tj.ch18.util.Paging;

@Controller
public class MainController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "main.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String main(Model model,String pageNum, Book book) {
		Paging paging = new Paging(bookService.cntBook(), pageNum, 3, 5); //pageSize blockSize
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		model.addAttribute("main", bookService.bookList(book));
		model.addAttribute("paging", paging);
		return "main/main";
	}
}
