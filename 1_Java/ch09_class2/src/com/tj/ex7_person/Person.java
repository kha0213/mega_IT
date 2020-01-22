package com.tj.ex7_person;

public class Person {
	private String name;
	private int money;
	public static int company_money;
	
	public Person(String name) {
		this.name=name;
	}
	public void currentMoney() {
		System.out.print(name+"님 개인자산 : "+money+"원 입니다.\t");
		System.out.println(name+"님 회사공금 : "+company_money+"원 입니다.");
	}
	public void saveMoney(int money) {
		this.money +=money;
	}
	public void saveCompany_money(int money) {
		this.company_money +=money;
	}
	public static void staticTestMethod() {
		System.out.println("static 메소드 test");
	}

}


