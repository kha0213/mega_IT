package com.tj.bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		String resourceLocation = "applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		My_info my_info = ctx.getBean("my_info",My_info.class);
		my_info.get_info();
		ctx.close();
	}
}

