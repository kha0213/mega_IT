package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		int i = sc.nextInt();
		System.out.println("�Է��� ������? "+i);
		System.out.println("�̸� �Է���");
		String name = sc.next();
		System.out.println("�Է��� �̸���? "+name);
		System.out.println("�ּ� �Է���");
		sc.nextLine(); // ���ۿ� �����ִ� \n�� ����� ����
		String address = sc.nextLine();
		System.out.println("�ּҴ�? "+address);
		System.out.println("~~~��~~~~~");
		sc.close();
	}

}
