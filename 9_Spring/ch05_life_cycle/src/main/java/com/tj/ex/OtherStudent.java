package com.tj.ex;

import javax.annotation.*;

public class OtherStudent {
	private String name;
	private int age;
	public OtherStudent(String name, int age) {
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
	
	@PostConstruct
	public void init() {
		System.out.println("★ OtherStudent 빈 객체 막 생성함 ★");
	}
	@PreDestroy
	public void destory() {
		System.out.println("★ OtherStudent 빈 객체 막 소멸하였음 ★");
	}
}
