package com.tj.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Test_main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성
		ConfigurableEnvironment env = ctx.getEnvironment(); // 환경설정 변수 생성
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties")); //확장자가 무조건 properties여야한다.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		ctx.load("classpath:applicationContext1.xml");
		ctx.refresh();
		Admin_info admin_info = ctx.getBean("admin_info",Admin_info.class);
		System.out.println(admin_info);
		ctx.close();
	}
}
