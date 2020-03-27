package com.tj.ex5autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Student_info {
	@Autowired
	private Student student;
	public Student getStudent() {
		return student;
	}
	
			
}
