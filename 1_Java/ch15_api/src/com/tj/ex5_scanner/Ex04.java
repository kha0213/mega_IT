package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸�?");
		String name = scMain.next();
		System.out.println("�̸��� "+name);
		action(scMain);
		System.out.print("����?");
		int age = scMain.nextInt();
		System.out.println("�Է��� ���̴� "+age);
		
		
		
		
		scMain.close();
	}//main

	private static void action(Scanner scAction) {// ������ �޾� ����ϴ� ��
		System.out.print("������? ");
		String nickName = scAction.next();
		System.out.println("������ "+nickName);
	}
}
