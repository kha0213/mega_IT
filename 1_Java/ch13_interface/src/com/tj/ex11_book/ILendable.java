package com.tj.ex11_book;

public interface ILendable {
	public boolean BOOK_STATE_NOMAL = true; //������� ����
	public boolean BOOK_STATE_BORROWED = false; //������
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState(); //���� ������ ���� ���

}
