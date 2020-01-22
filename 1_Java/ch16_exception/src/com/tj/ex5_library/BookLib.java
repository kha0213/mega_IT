package com.tj.ex5_library;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private boolean bookState;
	private String borrower;
	private Date checkOutDate;
	long day,diff;
	String answer;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Scanner sc = new Scanner(System.in);
		
	public BookLib() {
		super();
	}
	public BookLib(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		bookState = STATE_NORMAL;
	}


	@Override
	public void checkOut(String borrower) throws Exception {
		if(bookState==STATE_BORROWED) {
			throw new Exception("에러발생!! 책이 이미 대출중입니다. 관리자에게 문의하세요");
		}
		checkOutDate = new Date();
		this.borrower=borrower;
		bookState = STATE_BORROWED;
		System.out.println(this.borrower+"님 "+sdf.format(checkOutDate)+"일에 대출처리되셨습니다. 반납기한은 14일입니다. 꼭 지켜주세요.");
	}

	@Override
	public void checkIn() throws Exception {
		if(bookState==STATE_NORMAL) {
			throw new Exception("에러발생!!["+bookTitle+"]책이 이미 도서관에 있습니다. 관리자에게 문의하세요.");
		}
		Date now = new Date();
		diff = now.getTime()-checkOutDate.getTime();
		day = diff/ (24*60*60*1000);
		if(day>14) {
			System.out.println(day-14+"일 연체하셨습니다. 연체료 ["+((day-14)*100)+"]원 입니다. 지불하셔야 반납처리됩니다. \n반납하시겠습니까?(Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("반납처리가 중단되었습니다. 연체료 ["+((day-14)*100)+"]원 을 지불하세요.");
				return;
			}else if(answer.equalsIgnoreCase("y")) {
				System.out.println(((day-14)*100)+"원 감사합니다. 반납처리 진행하겠습니다.");
			}else {
				System.out.println("Y나 N을 입력하여 주시길 바랍니다. 다시 진행해주세요.");
				return;
			}
			
		}
		System.out.print(borrower+"님 "+sdf.format(now)+"일에 반납처리 되었습니다. ");
		
		borrower=null;
		checkOutDate = null;
		bookState = STATE_NORMAL;
	}//checkIn
	
	@Override
	public String toString() {
		if(bookState==STATE_NORMAL) {
			return "[책 번호]"+bookNo+" [책 이름]"+bookTitle+" [저자]"+writer+" || 책이 도서관에 보유중입니다.";
		}else {
		return "[책 번호]"+bookNo+" [책 이름]"+bookTitle+" [저자]"+writer+" ["+borrower+"]님이 "+sdf.format(checkOutDate)+"일에 대출하셨습니다.";
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
	public boolean isBookState() {
		return bookState;
	}
	public void setBookState(boolean bookState) {
		this.bookState = bookState;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	public String getAnswer() {
		return answer;
	}
}
