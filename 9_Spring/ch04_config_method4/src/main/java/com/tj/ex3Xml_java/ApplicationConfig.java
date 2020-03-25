package com.tj.ex3Xml_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tj.ex1xml.Student;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("게임");
		hobbies.add("게임2");
		Student student = new Student("호하이", 123, hobbies);
		student.setHeight(140);
		student.setWeight(100);
		return student;
	}
}
