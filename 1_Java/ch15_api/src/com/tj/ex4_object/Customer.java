package com.tj.ex4_object;

public class Customer {
	private String phone; //010-9999-9999
	private String name;
	private int point;
	private int sum;
	private String birth; //01-01
	private boolean vip; //false == 일반고객
	//Customer c = new Customer("010-9999-9999","롱롱이","12-19");
	
	public Customer(String phone, String name, String birth) {
		super();
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		point = 1000;
		sum = 0;
		vip = false;
		System.out.println(name+"회원님 가입 감사드립니다. 포인트 ★1000점★ 드려요.");
	}
	
	@Override
	public String toString() {
		return name+"("+phone+") 현재 포인트 : "+point+"점 누적구매금액 : "+sum+"원";
	}
	
	
	
	
}
