package com.tj.ex07_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 0개짜리 생성");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 1개짜리 생성");
	}
	
	//this. : 내 객체의 
    //this() : 내 객체의 생성자함수
	
	public Friend(String name,String tel) {
		this(name); 
		this.tel=tel;
		System.out.println("매개변수 2개짜리 생성");
	
	}
	public String infoString() {
		return name+" : "+tel;
	}

}
