package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("�̸�?");
		String name = scMain.next();
		System.out.println("�̸��� "+name);
		action();
		System.out.println("����?");
		int age = scMain.nextInt();
		System.out.println("�Է��� ���̴� "+age);
		
		
		
		
		scMain.close();
	}//main

	private static void action() {// ������ �޾� ����ϴ� ��
		Scanner scAction = new Scanner(System.in);
		System.out.println("������? ");
		String nickName = scAction.next();
		System.out.println("������ "+nickName);
	//	scAction.close();
	}
}
