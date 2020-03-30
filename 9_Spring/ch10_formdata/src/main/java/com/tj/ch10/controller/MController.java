package com.tj.ch10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.ch10.dto.Member_dto;

@Controller
@RequestMapping(value="member")
public class MController {
	@RequestMapping(value="join1")
	public String join1(HttpServletRequest request,Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
	@RequestMapping(value="join2")
	public String join2(@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("age") int age,
			@RequestParam("email") String email,
			@RequestParam("address") String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
	@RequestMapping("join3")
	public String join3(String name,String id,String pw, int age,String email,String address,Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}
	@RequestMapping("join4")
//	public String join4(@ModelAttribute("member") Member_dto member_dto,Model model) {
//		Member_dto member_dto = new Member_dto();
//		member_dto.setName(request.getParameter("name"));
//		member_dto.setId(request.getParameter("id"));
//		model.addAttribute("member", member_dto);
//		return "member/result1";
//	}
	public String join4(@ModelAttribute("member") Member_dto member_dto) {
		return "member/result4";
	}// 자동으로 model에 들어감
	
	@RequestMapping("join5")
	public String join5(Member_dto member_dto, Model model) {
		model.addAttribute("member", member_dto);
		return "member/result4";
	}
	@RequestMapping("join6")
	public String join6(Member_dto member) {
		//model.addAttribute("member_dto", member);
		return "member/result6";
	}
	
}
