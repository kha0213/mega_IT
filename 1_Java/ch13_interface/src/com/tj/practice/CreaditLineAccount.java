package com.tj.practice;

public class CreaditLineAccount extends CheckingAccount {
	private int creditLine; // �ѵ�

	public CreaditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	public CreaditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		setBalance(0);
		this.creditLine = creditLine;
	}

	public int pay(String cardNo, int amount) {
		if (this.getCardNo().equals(cardNo)) {
			if (creditLine < amount) {
				System.out.println("�ܿ� �ѵ��� " + creditLine + "�̶� ���� �����Ͽ����ϴ�.");
				return 0;
			} else if (amount < 0) {
				System.out.println("���� ������ ������ ��ǰ�� �� �� ����!");
				return 0;
			} else {
				creditLine -= amount;
				System.out.println("[�ſ�ī��� ����]" + amount + "���� �����ϼ̽��ϴ�. ���� �ѵ��� " + creditLine + "�� �Դϴ�.");
				return amount;
			}
		} else {
			System.out.println("ī���ȣ�� ��ġ���� �ʾ� ���Ÿ� �����Ͽ����ϴ�.");
			return 0;
		}
	}

	@Override
	public void printAccount() {
		System.out.println("****�շ����� ���� �����Դϴ�****");
		System.out.println("*[���¹�ȣ] " + getAccountNo());
		System.out.println("*[������] " + getOwnerName());
		System.out.println("*[�ſ�ī���ȣ]" + getCardNo());
		System.out.println("*[ī���ѵ�]" + creditLine + "��");
		System.out.println("*[�ܾ�]" + getBalance() + "��");
		System.out.println("************************");
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

}
