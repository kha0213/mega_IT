package com.tj.ch11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main",method = RequestMethod.GET)
	public String main() {
		return "main";
	}
//	@RequestMapping(value="student")
//	public String student(HttpServletRequest request,String id,Model model) {
//		String method = request.getMethod();
//		model.addAttribute("id", id);
//		model.addAttribute("method", method);
//		return "studentId";
//	}
	@RequestMapping(value="student",method=RequestMethod.GET)
	public String student(String id,Model model) {
		System.out.println("get방식 메소드");
		model.addAttribute("id",id);
		model.addAttribute("method","GET");
		return "studentId";
	}
	
	@RequestMapping(value="student", method=RequestMethod.POST)
	public ModelAndView studentpost(String id,ModelAndView modelAndView) {
		System.out.println("post방식 메소드");
		modelAndView.addObject("id", id);
		modelAndView.addObject("method", "POST");
		modelAndView.setViewName("studentId");
		return modelAndView;
	}
	@RequestMapping(value="studentConfirm")
	public String studentConfirm(String id,Model model) {
		model.addAttribute("id",id);
		if(id.equals("aaa")) {
			return "redirect:studentOk.do"; //request객체가 새롭게 만들어짐
		}
		return "redirect:studentNg.do";
	}
	@RequestMapping(value="studentOk")
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg")
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value="fullPath",method=RequestMethod.GET)
	public String fullPath() {
		return "redirect:http://localhost:8181/ch11/student/fullPath.jsp";
//		return "redirect:http://www.naver.com";
	}
}
