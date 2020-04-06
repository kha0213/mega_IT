package com.tj.ch18.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18.dto.Member;
import com.tj.ch18.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	private boolean joinPath = false;
	@RequestMapping(params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(Member member,HttpSession httpSession,Model model) {
		System.out.println(member);
		int result = memberService.joinMember(member, httpSession);
		if(result == 1) {
			model.addAttribute("joinResult", result);
		}else {
			model.addAttribute("errorMsg", "회원가입 에러");
		}
		return "member/loginForm";
	}
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid,Model model) {
		model.addAttribute("idConfirm",memberService.idConfirm(mid));
		return "member/idConfirmMsg";
	}
	@RequestMapping(params = "method=loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
	public String login(String mid,String mpw,HttpSession httpSession, Model model) {
		model.addAttribute("msg", memberService.loginCheck(mid,mpw, httpSession));
		System.out.println(httpSession.getAttribute("member"));
		return "forward:main.do";
	}
	@RequestMapping(params = "method=modifyForm", method = RequestMethod.GET)
	public String modifyForm() {
		return "member/modifyForm";
	}
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify(Member member, HttpSession httpSession,Model model) {
		int result = memberService.modifyMember(member, httpSession);
		if(result == 1) {
			model.addAttribute("modifyResult",result);
		}else {
			model.addAttribute("errorMsg", "정보수정 오류");
		}
		return "forward:main.do";
	}
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "forward:main.do";
	}
	
}
