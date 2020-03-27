package com.tj.ex2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_main_java {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ancoapctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminInfo info = ancoapctx.getBean("adminInfo",AdminInfo.class);
		
		System.out.println(info.getAdminId());
		System.out.println(info.getAdminPw());
		System.out.println(info.getSub_adminId());
		System.out.println(info.getSub_adminPw());
		
		ancoapctx.close();
	}
}
