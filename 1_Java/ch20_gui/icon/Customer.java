package com.tj.homework;

public class Customer {
	private String phone;
	private String name;
	private int point;
	
	
	public Customer(String phone, String name) {
		super();
		this.phone = phone;
		this.name = name;
		this.point = 1000;
	}


	@Override
	public String toString() {
		return "[�̸�] "+name+"\t[��ȭ��ȣ] "+phone +"\t[����Ʈ] "  +  point+"\r\n";
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
}
