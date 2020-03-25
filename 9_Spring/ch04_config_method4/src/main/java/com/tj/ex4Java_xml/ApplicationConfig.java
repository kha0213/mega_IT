package com.tj.ex4Java_xml;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.tj.ex1xml.Student;

@Configuration
@ImportResource("classpath:ex4/applicationCTX4.xml")

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
