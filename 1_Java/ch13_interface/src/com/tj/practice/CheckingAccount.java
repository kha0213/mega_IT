package com.tj.practice;

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		setBalance(0);
	}

	public int pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo)) {
			if (amount > getBalance()) {
				System.out.println("�ܾ��� " + amount + "���̶� ��� �Ұ��մϴ�.");
				return 0;
			} else if (amount < 0) {
				System.out.println("����! ������ ���� �� �� ����.");
				return 0;
			} else {
				setBalance(getBalance() - amount);
				System.out.println("[üũī��� ����]������ ���¿� " + amount + "���� ��ݵǾ� �����ܾ��� " + getBalance() + "���� �Ǿ����ϴ�.");
				return amount;
			}
		} // ��ȣ����
		else {
			System.out.println("ī���ȣ�� ��ġ���� �ʾ� ���� �����Ͽ����ϴ�.");
			return 0;
		}
	}// pay

	@Override
	public void printAccount() {
		System.out.println("****�շ����� ���� �����Դϴ�****");
		System.out.println("[���¹�ȣ] " + getAccountNo());
		System.out.println("[������] " + getOwnerName());
		System.out.println("[üũī���ȣ]" + cardNo);
		System.out.println("[�ܾ�]" + getBalance());
		System.out.println("************************");

	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
