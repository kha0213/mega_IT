package com.tj.ex3_human;

public class Man {
	private int age;
	public Man() {
		System.out.println("�Ű�����=�Ķ���Ͱ� ���� Man ������");
	}
	public Man(int age) {
		this.age=age;
		
		System.out.println("�Ű�����=�Ķ���Ͱ� �ִ� Man ������");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



}//class
