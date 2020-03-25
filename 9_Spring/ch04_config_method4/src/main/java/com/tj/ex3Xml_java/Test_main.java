package com.tj.ex3Xml_java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.tj.ex1xml.Student;

public class Test_main {
	public static void main(String[] args) {
		AbstractApplicationContext abapctx = new GenericXmlApplicationContext("classpath:ex3/applicationCTX3.xml");
		Student st1 = abapctx.getBean("student1",Student.class);
		Student st2 = abapctx.getBean("student2",Student.class);
		
		System.out.println(st1);
		System.out.println(st2);
	}
}
