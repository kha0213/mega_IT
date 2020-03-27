package com.tj.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext1.xml");
		ctx.refresh();
		Student student = ctx.getBean("student",Student.class);
		Worker worker = ctx.getBean("worker",Worker.class);
		student.getStudentInfo();
		worker.getWorkerInfo();
		ctx.close();
		
	}
}
