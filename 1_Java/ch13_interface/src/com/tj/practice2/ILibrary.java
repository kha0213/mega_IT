package com.tj.practice2;

public interface ILibrary {
	public boolean STATE_BORROWED=true; //대여중
	public boolean STATE_NORMAL=false; // 소장중
	public void checkOut(String Title,String date);
	public void checkIn();
	public void printState();
	

}
