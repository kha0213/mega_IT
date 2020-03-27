package com.tj.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// "/" => 작업 수행 -> "home.jsp" 뷰단으로 이동
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("greeting", "안녕하세여/ 스프링, MVC");
		return "home";
	}
	@RequestMapping("main")
	public String main() {
		return "main/main";
	}
}
