package com.tj.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.homework.dto.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input(Student student) {
		int kor = student.getKor();
		int eng = student.getEng();
		int mat = student.getMat();
		int sum = kor+eng+mat;
		double avg = ((kor+eng+mat)/3.0);
		avg = Math.round(avg*100)/100.0;
		student.setSum(sum);
		student.setAvg(avg);
		return "input";
	}
}