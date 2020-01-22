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
			System.out.println(borrower+"님 "+checkOutDate+"일에 CD 대출 승인되었습니다.");
			state=ILendable.STATE_BORROWED;
		}
		else {
			System.out.println("CD가 대출중입니다.");
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
			System.out.println("CD가 이미 도서관에 있습니다.");
		}
	}

	@Override
	public void printState() {
		System.out.println("CD번호: "+getCdNo()+" CD제목: "+getCdTitle());
		if(state==ILendable.STATE_NOMAL) {
			System.out.println("대출 가능합니다.");
		}
		else {
			System.out.println("대출중입니다.");
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
