package com.tj.ex12_book;

public interface ILendable {
	public boolean STATE_NOMAL = true; //������� ����
	public boolean STATE_BORROWED = false; //������
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState(); //���� ������ ���� ���

}
