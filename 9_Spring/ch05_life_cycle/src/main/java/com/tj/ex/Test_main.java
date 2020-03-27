package com.tj.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //컨테이너 생성(환경설정)
		String resourceLocation = "classpath:applicationContext.xml";
		ctx.load(resourceLocation); // 파싱
		ctx.refresh(); // 빈 생성
		Student student = ctx.getBean("student",Student.class);
		OtherStudent otherStudent = ctx.getBean("otherStudent",OtherStudent.class);
		
		System.out.println("student= "+student);
		System.out.println("otherStudent= "+otherStudent);
		ctx.close();
		
	}
}
