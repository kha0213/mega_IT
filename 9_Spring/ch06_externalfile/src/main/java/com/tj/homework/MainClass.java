package com.tj.homework;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("dev? run?");
		String answer = sc.next();
		if(!answer.equals("dev")) {
			answer = "run";
		}
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(answer);
		ctx.load("classpath:homework/dev.xml","classpath:homework/run.xml");
		ctx.refresh();
		
		EnvInfo envInfo = ctx.getBean("envInfo",EnvInfo.class);
		System.out.println(envInfo);
		
		ctx.close();
		sc.close();
	}
}
