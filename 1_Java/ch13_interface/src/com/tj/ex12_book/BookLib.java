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
			System.out.println("책이 대출중입니다.");
		}
	}

	@Override
	public void checkIn() {
		if(state==STATE_NOMAL) {
			System.out.println("책이 도서관에 이미 있습니다.");
		}
		else {
		borrower = null;
		checkOutDate = null;
		state=STATE_NOMAL;
		System.out.println("책 반납처리되었습니다.");
		}
	}

	@Override
	public void printState() {
		System.out.println("책 번호: "+getBookNo()+" 책 이름:"+getBookTitle()+" 저자: "+getWriter());	
		if(state==STATE_BORROWED) {
			System.out.println(borrower+"님이 "+checkOutDate+"일에 대출하셨습니다.");
		}
		else {
			System.out.println("대출 가능 상태입니다.");
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
