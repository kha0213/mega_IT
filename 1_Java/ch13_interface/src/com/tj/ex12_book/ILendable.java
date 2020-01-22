package com.tj.ex12_book;

public interface ILendable {
	public boolean STATE_NOMAL = true; //대출되지 않음
	public boolean STATE_BORROWED = false; //대출중
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState(); //도서 정보와 상태 출력

}
