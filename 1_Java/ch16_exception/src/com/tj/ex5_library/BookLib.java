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
			throw new Exception("�����߻�!! å�� �̹� �������Դϴ�. �����ڿ��� �����ϼ���");
		}
		checkOutDate = new Date();
		this.borrower=borrower;
		bookState = STATE_BORROWED;
		System.out.println(this.borrower+"�� "+sdf.format(checkOutDate)+"�Ͽ� ����ó���Ǽ̽��ϴ�. �ݳ������� 14���Դϴ�. �� �����ּ���.");
	}

	@Override
	public void checkIn() throws Exception {
		if(bookState==STATE_NORMAL) {
			throw new Exception("�����߻�!!["+bookTitle+"]å�� �̹� �������� �ֽ��ϴ�. �����ڿ��� �����ϼ���.");
		}
		Date now = new Date();
		diff = now.getTime()-checkOutDate.getTime();
		day = diff/ (24*60*60*1000);
		if(day>14) {
			System.out.println(day-14+"�� ��ü�ϼ̽��ϴ�. ��ü�� ["+((day-14)*100)+"]�� �Դϴ�. �����ϼž� �ݳ�ó���˴ϴ�. \n�ݳ��Ͻðڽ��ϱ�?(Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("�ݳ�ó���� �ߴܵǾ����ϴ�. ��ü�� ["+((day-14)*100)+"]�� �� �����ϼ���.");
				return;
			}else if(answer.equalsIgnoreCase("y")) {
				System.out.println(((day-14)*100)+"�� �����մϴ�. �ݳ�ó�� �����ϰڽ��ϴ�.");
			}else {
				System.out.println("Y�� N�� �Է��Ͽ� �ֽñ� �ٶ��ϴ�. �ٽ� �������ּ���.");
				return;
			}
			
		}
		System.out.print(borrower+"�� "+sdf.format(now)+"�Ͽ� �ݳ�ó�� �Ǿ����ϴ�. ");
		
		borrower=null;
		checkOutDate = null;
		bookState = STATE_NORMAL;
	}//checkIn
	
	@Override
	public String toString() {
		if(bookState==STATE_NORMAL) {
			return "[å ��ȣ]"+bookNo+" [å �̸�]"+bookTitle+" [����]"+writer+" || å�� �������� �������Դϴ�.";
		}else {
		return "[å ��ȣ]"+bookNo+" [å �̸�]"+bookTitle+" [����]"+writer+" ["+borrower+"]���� "+sdf.format(checkOutDate)+"�Ͽ� �����ϼ̽��ϴ�.";
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
