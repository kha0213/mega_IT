package com.tj.ex12_book;

public class BookLib extends BookInfo implements ILendable{
	private boolean state;
	private String borrower;
	private String checkOutDate;
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		state = STATE_NOMAL;
	}
	
	

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_NOMAL) {
		this.borrower=borrower;
		this.checkOutDate=checkOutDate;
		state=STATE_BORROWED;
	
		}
		else {
			System.out.println("å�� �������Դϴ�.");
		}
	}

	@Override
	public void checkIn() {
		if(state==STATE_NOMAL) {
			System.out.println("å�� �������� �̹� �ֽ��ϴ�.");
		}
		else {
		borrower = null;
		checkOutDate = null;
		state=STATE_NOMAL;
		System.out.println("å �ݳ�ó���Ǿ����ϴ�.");
		}
	}

	@Override
	public void printState() {
		System.out.println("å ��ȣ: "+getBookNo()+" å �̸�:"+getBookTitle()+" ����: "+getWriter());	
		if(state==STATE_BORROWED) {
			System.out.println(borrower+"���� "+checkOutDate+"�Ͽ� �����ϼ̽��ϴ�.");
		}
		else {
			System.out.println("���� ���� �����Դϴ�.");
		}
	}



	public boolean isBookState() {
		return state;
	}

	public void setBookState(boolean bookState) {
		this.state = bookState;
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
	
	
	

}