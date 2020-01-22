package com.tj.ex8_atm;

public class ATM {
	private int balance;
	public ATM(int balance) {
		this.balance=balance;
	}
	
	public synchronized void deposit(int amount, String name) {
		System.out.println(name+"가 입금시작 ★★★");
		balance += amount;
		System.out.println(name+"가 "+amount+"원 입금해서 잔액 "+balance);
		System.out.println(name+"가 입금끝 ★★★");
	}
	
	public synchronized void withdraw(int amount, String name) {
		System.out.println(name+"가 출금시작 ◎◎◎");
		balance -= amount;
		System.out.println(name+"가 "+amount+"원 출금해서 잔액 "+balance);
		System.out.println(name+"가 출금끝 ◎◎◎");
	}
	
	
	
	public int getBalance() {
		return balance;
	}

}
