package com.tj.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("dev? run?");
		config = sc.next();
		if(!config.equals("dev")) {
			config = "run";
		}
		String resourceLocation1 = "classpath:applicationCTX_run.xml";
		String resourceLocation2 = "classpath:applicationCTX_dev.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load(resourceLocation1,resourceLocation2);
		ctx.refresh();
		ServerInfo serverInfo = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip번호: "+serverInfo.getIpNum());
		System.out.println("port번호 : "+serverInfo.getPortNum());
		sc.close();
		ctx.close();
	}
}
