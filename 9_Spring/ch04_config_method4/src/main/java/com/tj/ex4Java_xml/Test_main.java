package com.tj.ex4Java_xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tj.ex1xml.Student;

public class Test_main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student st1 = ctx.getBean("student1",Student.class);
		Student st2 = ctx.getBean("student2",Student.class);
		System.out.println(st1);
		System.out.println(st2);
	}
}
