package com.tj.ex12_book;


public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private boolean state;
	
	public CDLib(String cdNo, String cdTitle) {
		super(cdNo, cdTitle);
		state=STATE_NOMAL;
	}

	
	
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==ILendable.STATE_NOMAL) {
			System.out.println(borrower+"�� "+checkOutDate+"�Ͽ� CD ���� ���εǾ����ϴ�.");
			state=ILendable.STATE_BORROWED;
		}
		else {
			System.out.println("CD�� �������Դϴ�.");
		}
	}

	@Override
	public void checkIn() {
		if(state==ILendable.STATE_BORROWED) {
			state=ILendable.STATE_NOMAL;
			borrower = null;
			checkOutDate=null;
		}
		else {
			System.out.println("CD�� �̹� �������� �ֽ��ϴ�.");
		}
	}

	@Override
	public void printState() {
		System.out.println("CD��ȣ: "+getCdNo()+" CD����: "+getCdTitle());
		if(state==ILendable.STATE_NOMAL) {
			System.out.println("���� �����մϴ�.");
		}
		else {
			System.out.println("�������Դϴ�.");
		}
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	

}
