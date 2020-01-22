package com.tj.ex4_man;

public class Man {
	
	private int age;
	private int height;
	private int weight;
	private String phoneNum;
	
	
	public Man() {System.out.println("매개변수 없는 생성자 호출");
		
	}
	public Man(int age,int height,int weight,String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;		
	}
	public Man(int height,int weight) {
		this.height = height;
		this.weight = weight;
	}
	public Man(int height) {
		this.height = height;
	}
	public Man(double weight) {
		this.weight = (int)weight;
	}
	
	public double calculateBMI() {
		double result = weight / ((height*0.01)*(height*0.01));
		return result;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return height;
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum=phoneNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	
	
}
