package com.tj.ex5autowired;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		String resourceLocation = "classpath:ex5/applicationContext.xml";
		AbstractApplicationContext abapctx = new GenericXmlApplicationContext(resourceLocation);
		Student_info st_info = abapctx.getBean("student_info",Student_info.class);
		System.out.println(st_info.getStudent());
		abapctx.close();
		
	}
}
