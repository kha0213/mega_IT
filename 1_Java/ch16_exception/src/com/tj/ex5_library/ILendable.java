package com.tj.ex5_library;

import java.util.Date;

public interface ILendable {
	public boolean STATE_BORROWED=false;
	public boolean STATE_NORMAL=true;
	public void checkOut(String bookTitle) throws Exception;
	public void checkIn() throws Exception;
}
