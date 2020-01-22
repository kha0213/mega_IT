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
		System.out.println(ownerName + " 고객님의 계좌에 " + amount + "원이 입금되어 계좌잔액이 " + balance + "원이 되었습니다.");
	}

	public int withdraw(int amount) {
		if (amount > balance) {
			System.out.println("현재 고객님의 계좌에 " + balance + "원이 있어 신청하신 " + amount + "원을 인출하지 못하였습니다.");
			return 0;
		} else if (amount < 0) {
			System.out.println("떼끼!! 음수인 돈을 인출할 수는 없어요.");
			return 0;
		} else {
			balance -= amount;
			System.out.println(ownerName + " 고객님의 계좌에 " + amount + "원이 출금되어 계좌잔액이 " + balance + "원이 되었습니다.");
			return amount;
		}
	}

	public void printAccount() {
		System.out.println("****롱롱은행 계좌 정보입니다****");
		System.out.println("[계좌번호] " + accountNo);
		System.out.println("[예금주] " + ownerName);
		System.out.println("[잔액]" + balance);
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
