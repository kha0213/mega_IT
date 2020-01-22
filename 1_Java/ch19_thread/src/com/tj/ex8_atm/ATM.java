package com.tj.ex8_atm;

public class ATM {
	private int balance;
	public ATM(int balance) {
		this.balance=balance;
	}
	
	public synchronized void deposit(int amount, String name) {
		System.out.println(name+"�� �Աݽ��� �ڡڡ�");
		balance += amount;
		System.out.println(name+"�� "+amount+"�� �Ա��ؼ� �ܾ� "+balance);
		System.out.println(name+"�� �Աݳ� �ڡڡ�");
	}
	
	public synchronized void withdraw(int amount, String name) {
		System.out.println(name+"�� ��ݽ��� �ݡݡ�");
		balance -= amount;
		System.out.println(name+"�� "+amount+"�� ����ؼ� �ܾ� "+balance);
		System.out.println(name+"�� ��ݳ� �ݡݡ�");
	}
	
	
	
	public int getBalance() {
		return balance;
	}

}
