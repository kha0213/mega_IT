package com.tj.ex8_atm;

public class ATM_Main {

	public static void main(String[] args) {
		ATM atm = new ATM(50000);
		ATM_ACTION card = new ATM_ACTION(atm);
		Thread th1 = new Thread(card, "MOM");
		Thread th2 = new Thread(card, "DAD");
		
		th1.start();
		th2.start();
	}

}
