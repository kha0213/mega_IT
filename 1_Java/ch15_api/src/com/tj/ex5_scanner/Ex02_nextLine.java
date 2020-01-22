package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주소는?");
		String address = sc.nextLine();
		System.out.println("입력한 주소는: "+address);
		
		
		System.out.println("이름은?");
		String name = sc.nextLine();
		System.out.println("입력한 이름는: "+name);
		
		System.out.println("정수를 입력하세요");
		int i = sc.nextInt();
		System.out.println("입력한 정수는: "+i);
		
		
		System.out.println("~~~끝~~~~~");
		
		
		sc.close();
	}
}
