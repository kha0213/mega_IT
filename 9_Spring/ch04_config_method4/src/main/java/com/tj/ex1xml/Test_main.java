package com.tj.ex1xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
	
	String resourceLocation1 = "classpath:ex1/applicationCTX1.xml";
	String resourceLocation2 = "classpath:ex1/applicationCTX2.xml";
	AbstractApplicationContext abapctx = new GenericXmlApplicationContext(resourceLocation1,resourceLocation2);
		
	Student student1 = abapctx.getBean("student1",Student.class);
	Student_info studentInfo = abapctx.getBean("student_info",Student_info.class);
	Student student3 = studentInfo.getStudent();

	System.out.println("student1 : "+student1);
	System.out.println("student3 : "+student3);
	
	if(student1.equals(student3)) {
		System.out.println("st1과 st3 주소가 같다");
	}else {
		System.out.println("st1과 st3 주소가 다르다");
	}
	
	student3.setName("아이유");
	System.out.println("student1 : "+student1);
	System.out.println("student3 : "+student3);
	Family family = abapctx.getBean("family",Family.class);
	System.out.println(family.getBrotherName());
	System.out.println(family.getSisterName());
	
	abapctx.close();
	
	
	}
}
