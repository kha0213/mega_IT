package com.tj.ex5_account;

public class Account {

	private String accountNumber;
	private String ownerName;
	private int balance;

	public Account() {
//		System.out.println("***���� ���� ���α׷��Դϴ�.***");
//		System.out.println("���� ��ȣ, ���� �̸�, �ܾ� �������ּ���");
	}

	public Account(String accountNumer, String accountName) {
		this.ownerName = accountName;
		this.accountNumber = accountNumer;
//		System.out.println("***���� ���� ���α׷��Դϴ�.***");
//		System.out.printf("���� ��ȣ %s ���� �̸� %s �����Ǿ����ϴ�.\n",ownerName,accountNumer);
//		System.out.println("�ܾ� �������ּ���");
	}

	public Account(String accountNumer, String accountName, int balance) {
		this.ownerName = accountName;
		this.accountNumber = accountNumer;
		this.balance = balance;
//		System.out.println("***���� ���� ���α׷��Դϴ�.***");
//		System.out.printf("���� ��ȣ %s , ���� �̸� %s , �ܾ� %d���� �����Ǿ����ϴ�.\n",accountNumer,ownerName,balance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return ownerName;
	}

	public void setAccountName(String accountName) {		
		this.ownerName = accountName;
	}//setAccountName

	public int getBalance() {
		return balance;
	}//getBalance

	public void setBalance(int balance) {
		this.balance = balance;
	}//setBalance

	public int withdraw(int money) {
		if (money > balance) {
			System.out.println("��ȿ���� ���� ���Դϴ�. �ܾ� " + balance + "�� ���� ���� ���� �����Ͽ��ּ���");
			return money;
		}//if 
		else {
			balance -= money;
			System.out.println("������ ���¿��� " + money + "���� ����Ǿ� " + balance + "���� ���ҽ��ϴ�.");
			return 0;
		}//else
	}//withdraw

	public void deposit(int deposit) {
		balance += deposit;
		System.out.println("������ ���¿��� " + deposit + "���� �ԱݵǾ� �ܾ� " + balance + "���� ���ҽ��ϴ�.");
	}

}// class
