package com.tj.practice2;

public interface ILibrary {
	public boolean STATE_BORROWED=true; //�뿩��
	public boolean STATE_NORMAL=false; // ������
	public void checkOut(String Title,String date);
	public void checkIn();
	public void printState();
	

}
