package com.tj.ex2_swing;

public class Person {
	private String name;
	private String phone;
	private int age;
	public Person(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[이름]"+name+" [전화]"+phone+" [나이]"+age+"세\r\n";
	}
}
