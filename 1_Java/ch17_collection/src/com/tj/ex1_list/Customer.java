package com.tj.ex1_list;

public class Customer {
	private String name;
	private String phone;
	private String address;
	
	public Customer() {
	}
	
	public Customer(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return name+ " "+ phone+" "+ address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phone;
	}
	public void setPhoneNum(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
