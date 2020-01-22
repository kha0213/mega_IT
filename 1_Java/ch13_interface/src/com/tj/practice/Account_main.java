package com.tj.practice;

public class Account_main {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "ȫ�浿");
		CheckingAccount a2 = new CheckingAccount("222-2222", "������", 2000, "1234-1234-1234-1323");
		CheckingAccount a3 = new CreaditLineAccount("222-2222", "������", 2000, "1234-1234-1234-1323", 2000);
		Account a4 = new CreaditLineAccount("22", "������", "123-1414", 250000);
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		a1.printAccount();
		a2.pay("1234-1234-1234-1323", 200);
		a3.pay("1234-1234-1234-1323", 5000);
		a4.printAccount();

		Account[] acc = { a4, a3, a2 };
		for (Account a : acc) {
			if (a instanceof CreaditLineAccount) {
				((CreaditLineAccount) a).pay("222-2222", 2000);
			} else {
				System.out.println("pay �� �� ����~");
			}

		}

	}// main

}
