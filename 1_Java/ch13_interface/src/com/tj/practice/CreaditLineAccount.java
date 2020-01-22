package com.tj.practice;

public class CreaditLineAccount extends CheckingAccount {
	private int creditLine; // 한도

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
				System.out.println("잔여 한도가 " + creditLine + "이라 구매 실패하였습니다.");
				return 0;
			} else if (amount < 0) {
				System.out.println("떼끼 가격이 음수인 물품은 살 수 없어!");
				return 0;
			} else {
				creditLine -= amount;
				System.out.println("[신용카드로 구입]" + amount + "원을 구매하셨습니다. 남은 한도는 " + creditLine + "원 입니다.");
				return amount;
			}
		} else {
			System.out.println("카드번호가 일치하지 않아 구매를 실패하였습니다.");
			return 0;
		}
	}

	@Override
	public void printAccount() {
		System.out.println("****롱롱은행 계좌 정보입니다****");
		System.out.println("*[계좌번호] " + getAccountNo());
		System.out.println("*[예금주] " + getOwnerName());
		System.out.println("*[신용카드번호]" + getCardNo());
		System.out.println("*[카드한도]" + creditLine + "원");
		System.out.println("*[잔액]" + getBalance() + "원");
		System.out.println("************************");
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

}
