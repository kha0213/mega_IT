package com.tj.ex2java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tj.ex1xml.Student;

public class Test_main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1",Student.class);
		Student student2 = (Student) ctx.getBean("student2");
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		ctx.close();
	}
}
