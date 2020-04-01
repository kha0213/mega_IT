package com.tj.ch12.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch12.dto.Student;
import com.tj.ch12.dto.Student_validator;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	@RequestMapping(value = "input.do", method = RequestMethod.POST)
//	public String input(@Validated Student student,BindingResult errors, Model model) {
//		Student_validator validator = new Student_validator();
//		validator.validate(student, errors);
//		if(errors.hasErrors()) {
//			if(errors.getFieldError("name")!=null) {
//				model.addAttribute("error_msg", "name은 반드시 입력하세요");
//			}else if(errors.getFieldError("id")!=null) {
//				model.addAttribute("error_msg", "id는 자연수로 입력하세요");
//			}
//			
//			return "inputForm";
//		}
//		return "inputResult";
//	}
	public String input(@Valid Student student,BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("error_msg", "name은 반드시 입력하세요");
			}else if(errors.getFieldError("id")!=null) {
				model.addAttribute("error_msg", "id는 자연수로 입력하세요");
			}
			
			return "inputForm";
		}
		return "inputResult";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new Student_validator());
	}
}
