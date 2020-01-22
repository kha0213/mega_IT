package com.tj.ex5_account;

public class Account {

	private String accountNumber;
	private String ownerName;
	private int balance;

	public Account() {
//		System.out.println("***계좌 생성 프로그램입니다.***");
//		System.out.println("계좌 번호, 계좌 이름, 잔액 생성해주세요");
	}

	public Account(String accountNumer, String accountName) {
		this.ownerName = accountName;
		this.accountNumber = accountNumer;
//		System.out.println("***계좌 생성 프로그램입니다.***");
//		System.out.printf("계좌 번호 %s 계좌 이름 %s 생성되었습니다.\n",ownerName,accountNumer);
//		System.out.println("잔액 생성해주세요");
	}

	public Account(String accountNumer, String accountName, int balance) {
		this.ownerName = accountName;
		this.accountNumber = accountNumer;
		this.balance = balance;
//		System.out.println("***계좌 생성 프로그램입니다.***");
//		System.out.printf("계좌 번호 %s , 계좌 이름 %s , 잔액 %d원이 생성되었습니다.\n",accountNumer,ownerName,balance);
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
			System.out.println("유효하지 않은 값입니다. 잔액 " + balance + "원 보다 적은 돈을 인출하여주세요");
			return money;
		}//if 
		else {
			balance -= money;
			System.out.println("고객님의 계좌에서 " + money + "원이 인출되어 " + balance + "원이 남았습니다.");
			return 0;
		}//else
	}//withdraw

	public void deposit(int deposit) {
		balance += deposit;
		System.out.println("고객님의 계좌에서 " + deposit + "원이 입금되어 잔액 " + balance + "원이 남았습니다.");
	}

}// class
