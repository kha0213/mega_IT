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
				System.out.println("잔액이 " + amount + "원이라 사용 불가합니다.");
				return 0;
			} else if (amount < 0) {
				System.out.println("떼끼! 음수인 돈을 살 수 없어.");
				return 0;
			} else {
				setBalance(getBalance() - amount);
				System.out.println("[체크카드로 구입]고객님의 계좌에 " + amount + "원이 출금되어 계좌잔액이 " + getBalance() + "원이 되었습니다.");
				return amount;
			}
		} // 번호맞춤
		else {
			System.out.println("카드번호가 일치하지 않아 구매 실패하였습니다.");
			return 0;
		}
	}// pay

	@Override
	public void printAccount() {
		System.out.println("****롱롱은행 계좌 정보입니다****");
		System.out.println("[계좌번호] " + getAccountNo());
		System.out.println("[예금주] " + getOwnerName());
		System.out.println("[체크카드번호]" + cardNo);
		System.out.println("[잔액]" + getBalance());
		System.out.println("************************");

	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
