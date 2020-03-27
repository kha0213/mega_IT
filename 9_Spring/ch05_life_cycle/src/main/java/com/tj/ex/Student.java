package com.tj.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class Student implements InitializingBean, DisposableBean, EnvironmentAware {
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public void afterPropertiesSet() throws Exception {// 빈이 생성 될 때
		System.out.println("막 Student 빈 객체 생성 함 초기화 작업 여기서");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Student 빈 객체 사라짐 ㅃㅇㅃㅇ");
	}
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Student 생성 되기 바로 직전에 환경이 설정 되는 그 시점");
	}
	
}
