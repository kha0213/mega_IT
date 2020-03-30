package com.tj.ch10.dto;

public class Member_dto {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	// 매개변수 없는 생성자, setter, getter 반드시 있어야한다.
	
	
	
	public Member_dto(String name, String id, String pw, int age, String email, String address) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	public Member_dto() {
		super();
	}
	@Override
	public String toString() {
		return "Member_dto [name=" + name + ", id=" + id + ", pw=" + pw + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
