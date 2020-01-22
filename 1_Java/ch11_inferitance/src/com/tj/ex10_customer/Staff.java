package com.tj.ex10_customer;

public class Staff extends Person {
	private String hiredate; // 입사일
	private String department; //부서
	//Staff s = new Staff("홍길동","999-9999","2010-11-25","자재부")
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println("스태프 "+name+"님 입사일 "+hiredate+"입니다.");
	}
	@Override
	public String infoString() {
		return super.infoString()+" [부서]"+hiredate;
	}
	

}
