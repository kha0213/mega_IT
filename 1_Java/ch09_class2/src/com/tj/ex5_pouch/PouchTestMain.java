package com.tj.ex5_pouch;

public class PouchTestMain {
	public static void main(String[] args) {
		Child first = new Child("ù°�浿��");
		Child second = new Child("��°�ʸ���");
		Child third = new Child("��°������");
		first.takeMoney(100);
		second.takeMoney(90);
		third.takeMoney(100);
		System.out.println("���� ���� �� : "+MomPouch.money);

	}

}
