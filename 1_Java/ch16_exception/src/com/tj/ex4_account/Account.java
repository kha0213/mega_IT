package com.tj.ex4_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	
	public Account() {
	}


	public Account(String accountNo, String ownerName) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int amount) {//���� �� �������� -> ���� -> ���� �� �����������
		System.out.println("������ "+this);
		balance +=amount;
		System.out.println("������ "+this);
	}
	
	public void withdraw(int amount) throws Exception {// �ܾװ� ��ݱݾ׺� ->(���ɽ�) ����� �������� -> ��� -> ����� ��������
		if(balance<amount) {
			throw new Exception(amount+"���� ����ϱ⿡�� �ܾ�("+balance+")�� �����մϴ�.");
		}
		System.out.println("����� "+this);
		balance -=amount;
		System.out.println("����� "+this);
	}
	
	
	
	
	@Override
	public String toString() {
		String temp = "���¹�ȣ : "+accountNo;
		temp += "\t������ : "+ownerName;
		temp += "\t�ܾ� : "+balance;
		return temp;
	}
	
	
	
}
