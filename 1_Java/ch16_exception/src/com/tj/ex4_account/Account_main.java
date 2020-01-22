package com.tj.ex4_account;

public class Account_main {
	public static void main(String[] args) {
		Account ob1 = new Account("499402-01","∑’∑’¿Ã",1958000);
		Account ob2 = new Account("22-22","∑’∑’¿Ã",10000);
		System.out.println(ob1);
		ob1.deposit(15000);
		
		try {
			ob1.withdraw(50000000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ob2.withdraw(20000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
