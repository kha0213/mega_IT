package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("이름?");
		String name = scMain.next();
		System.out.println("이름은 "+name);
		action();
		System.out.println("나이?");
		int age = scMain.nextInt();
		System.out.println("입력한 나이는 "+age);
		
		
		
		
		scMain.close();
	}//main

	private static void action() {// 별명을 받아 출력하는 일
		Scanner scAction = new Scanner(System.in);
		System.out.println("별명은? ");
		String nickName = scAction.next();
		System.out.println("별명은 "+nickName);
	//	scAction.close();
	}
}
