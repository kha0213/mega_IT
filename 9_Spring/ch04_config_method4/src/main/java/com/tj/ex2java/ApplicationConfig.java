package com.tj.ex2java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 스프링 설정파일임을 명시하는 어노테이션

import com.tj.ex1xml.Student;
@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("군것질");
		Student student = new Student("황길뒁", 990, hobbies);
		student.setHeight(130);
		student.setWeight(10);
		return student;
	}
	@Bean
	public Student student2() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("LOL");
		hobbies.add("야스");
		Student student = new Student("링링이", 10, hobbies);
		student.setHeight(190);
		student.setWeight(80);
		return student;
	}
}
