package com.tj.practice;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public void deposit(int amount) {
		balance += amount;
		System.out.println(ownerName + " ������ ���¿� " + amount + "���� �ԱݵǾ� �����ܾ��� " + balance + "���� �Ǿ����ϴ�.");
	}

	public int withdraw(int amount) {
		if (amount > balance) {
			System.out.println("���� ������ ���¿� " + balance + "���� �־� ��û�Ͻ� " + amount + "���� �������� ���Ͽ����ϴ�.");
			return 0;
		} else if (amount < 0) {
			System.out.println("����!! ������ ���� ������ ���� �����.");
			return 0;
		} else {
			balance -= amount;
			System.out.println(ownerName + " ������ ���¿� " + amount + "���� ��ݵǾ� �����ܾ��� " + balance + "���� �Ǿ����ϴ�.");
			return amount;
		}
	}

	public void printAccount() {
		System.out.println("****�շ����� ���� �����Դϴ�****");
		System.out.println("[���¹�ȣ] " + accountNo);
		System.out.println("[������] " + ownerName);
		System.out.println("[�ܾ�]" + balance);
		System.out.println("************************");

	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
