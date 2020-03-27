package com.tj.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tj.ch09.dto.Member;

@Controller
@RequestMapping("board")
public class BoardController {
	@RequestMapping("/view")
	public String view() {
		return "board/view";
	}
	@RequestMapping("content")
	public String content(Model model) {
		model.addAttribute("id", "aaaa");
		model.addAttribute("pw", "11");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	@RequestMapping(value="write")
	public ModelAndView write(ModelAndView mav) {
		Member member = new Member("ccc", "333");
		mav.addObject("member", member); //model.addAttribute 와 같다
		mav.setViewName("board/write"); //return에 viewPage와 같다
		return mav;
	}
	@RequestMapping("reply")
	public String reply() {
		return "board/reply";
	}
}
