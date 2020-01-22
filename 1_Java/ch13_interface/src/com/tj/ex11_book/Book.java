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
			System.out.println(bookTitle+"������ ���� �������Դϴ�. �ٸ�å�� �뿩���ּ���.");
			return;
		}
		this.borrower=borrower;
		this.checkOutDate=checkOutDate;
		bookState=BOOK_STATE_BORROWED;
		System.out.println(borrower+"�� "+bookTitle+"å �뿩 �Ǿ����ϴ�. �뿩�Ⱓ 2���Դϴ�.\n������ �� �����ּ���.");
	}

	@Override
	public void checkIn() {
		if(bookState==BOOK_STATE_NOMAL) {
			System.out.println("å�� �̹� �ݳ��Ǿ����ϴ�. �����ڿ��� �����ϼ���");	
		}
		bookState=BOOK_STATE_NOMAL;
		System.out.println(borrower+"�� �ݳ�ó�� �Ǽ̽��ϴ�.�̿����ּż� ����帳�ϴ�.");
		borrower = null;
		checkOutDate = null;	
	}

	@Override
	public void printState() {
		System.out.print("å ��ȣ: "+bookNo);
		System.out.print("\tå �̸�: "+bookTitle);
		System.out.println("\t����: "+writer);
		if(bookState==BOOK_STATE_NOMAL) {
			System.out.println("å�� �������� �������Դϴ�.");
		}
		else {
			System.out.println(borrower+"���� "+checkOutDate+"�Ͽ� å�� �뿩�ϼ̽��ϴ�.");
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
