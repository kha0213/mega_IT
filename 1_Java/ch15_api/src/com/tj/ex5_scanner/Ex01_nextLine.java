package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int i = sc.nextInt();
		System.out.println("입력한 정수는? "+i);
		System.out.println("이름 입력해");
		String name = sc.next();
		System.out.println("입력한 이름은? "+name);
		System.out.println("주소 입력해");
		sc.nextLine(); // 버퍼에 남아있는 \n을 지우는 목적
		String address = sc.nextLine();
		System.out.println("주소는? "+address);
		System.out.println("~~~끝~~~~~");
		sc.close();
	}

}
