package com.tj.ex11_book;

public class Book implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private boolean bookState;
	
	public Book() {
		super();
	}

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		bookState=BOOK_STATE_NOMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(bookState==BOOK_STATE_BORROWED) {
			System.out.println(bookTitle+"도서는 현재 대출중입니다. 다른책을 대여해주세요.");
			return;
		}
		this.borrower=borrower;
		this.checkOutDate=checkOutDate;
		bookState=BOOK_STATE_BORROWED;
		System.out.println(borrower+"님 "+bookTitle+"책 대여 되었습니다. 대여기간 2주입니다.\n기한을 꼭 지켜주세요.");
	}

	@Override
	public void checkIn() {
		if(bookState==BOOK_STATE_NOMAL) {
			System.out.println("책이 이미 반납되었습니다. 관리자에게 문의하세요");	
		}
		bookState=BOOK_STATE_NOMAL;
		System.out.println(borrower+"님 반납처리 되셨습니다.이용해주셔서 감사드립니다.");
		borrower = null;
		checkOutDate = null;	
	}

	@Override
	public void printState() {
		System.out.print("책 번호: "+bookNo);
		System.out.print("\t책 이름: "+bookTitle);
		System.out.println("\t저자: "+writer);
		if(bookState==BOOK_STATE_NOMAL) {
			System.out.println("책을 도서관에 보유중입니다.");
		}
		else {
			System.out.println(borrower+"님이 "+checkOutDate+"일에 책을 대여하셨습니다.");
		}
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public boolean isBookState() {
		return bookState;
	}

	public void setBookState(boolean bookState) {
		this.bookState = bookState;
	}
	

}
