package com.tj.practice;

public class Student {
	private String data;
	private int no;
	private String name;
	private int age;
	private String major;
	private int fn;
	
	public Student() {
		
	}//생성자
	public Student(int no,String name,int age,String major) {
		this.no=no;
		this.name=name;
		this.age=age;
		this.major=major;
	}//생성자 3개
	
	public String infoString() {
		return "번호: "+no+"\t이름: "+name+"\t나이: "+age+"\t학과: "+major;
	}
	
	public void modify(int fn,String data) {
		switch (fn) {
		case 1: no=Integer.parseInt(data);
			break;
		case 2: name=data;
			break;
		case 3: age=Integer.parseInt(data);
			break;
		case 4: major=data;
			break;
//		default:
//			break;
		}
		
		
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getFn() {
		return fn;
	}
	public void setFn(int fn) {
		this.fn = fn;
	}

}
