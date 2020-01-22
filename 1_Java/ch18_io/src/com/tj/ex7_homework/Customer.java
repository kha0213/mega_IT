package com.tj.ex7_homework;

public class Customer {
	private String name;
	private String phoneNumber;
	private String birthday;
	private String address;
	public Customer(String name, String phoneNumber, String birthday, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.address = address;
	}
	public Customer() {
		super();
	}
	
	
	@Override
	public String toString() {
		return name +"\t" + phoneNumber + "\t" + birthday + "\t"+address;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
