package com.tj.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		String loc = "classpath:applicationContext2.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(loc);
		AdminInfo info = ctx.getBean("adminInfo",AdminInfo.class);
		System.out.println(info);
		ctx.close();
	}
}
