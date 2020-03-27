package com.tj.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext2.xml");
		ctx.refresh();
		Student2 student2 = ctx.getBean("student2",Student2.class);
		Worker2 worker2 = ctx.getBean("worker2",Worker2.class);
		student2.getStudentInfo();
		worker2.getWorkerInfo();
		ctx.close();
		
	}
}
