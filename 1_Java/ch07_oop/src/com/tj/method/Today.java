package com.tj.method;

import java.util.Scanner;

public class Today {
	public static void main(String[] args) {
		int you;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�������� ������ٲ��� 2~9 ������ ������ �Է��ϼ���!");
			you = sc.nextInt();
			if (you < 2 || you > 9) {
				System.out.println("����!! ���� �ȹٷ� �Է��ؾ��� 2~9 ������ ������ �Է���!!");
			} else {
				break;
			} // else
		} // while
		sc.close();
		
		Practice gu = new Practice();

		gu.guguPrint(you);

	}// main�޼��� _����ڷκ��� 2~9������ �������� �޴´�.

//	private static void guguPrint(int value) {// ����ڷκ��� ���� ��(value)�Ǳ������� ���
//		System.out.println("**" + value + "��**");
//		for (int i = 1; i < 10; i++) {
//			System.out.println(value + "X" + i + "=" + value * i);
//
//		}
//	}// guguPrint
}// class

