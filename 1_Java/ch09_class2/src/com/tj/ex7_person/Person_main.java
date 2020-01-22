package com.tj.ex7_person;

public class Person_main {
	public static void main(String[] args) {
		System.out.println(Person.company_money);
		Person.staticTestMethod();
		Person p1 = new Person("홍길동");
		Person p2 = new Person("남나리");
		p1.saveMoney(1000);
		p1.saveCompany_money(1000);
		p1.currentMoney();
		p2.saveMoney(2000);
		p2.saveCompany_money(3000);
		p2.currentMoney();
	}

}
