package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ּҴ�?");
		String address = sc.nextLine();
		System.out.println("�Է��� �ּҴ�: "+address);
		
		
		System.out.println("�̸���?");
		String name = sc.nextLine();
		System.out.println("�Է��� �̸���: "+name);
		
		System.out.println("������ �Է��ϼ���");
		int i = sc.nextInt();
		System.out.println("�Է��� ������: "+i);
		
		
		System.out.println("~~~��~~~~~");
		
		
		sc.close();
	}
}
