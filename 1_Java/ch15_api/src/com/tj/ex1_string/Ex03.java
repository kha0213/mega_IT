package com.tj.ex1_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// x를 누르면 종료 나머지 기능은 무한반복
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("원하는 기능번호는 1.대출, 2.반납, x:종료");
			fn = sc.next();
			if(fn.equalsIgnoreCase("x")) {
				break;
			}
			if (fn.equals("1")) {
				System.out.println("대출입니다.");
			} else if (fn.equals("2")) {
				System.out.println("반납입니다.");
			} else {
				System.out.println("잘못 입력해써");
			}

		} while (true);
		System.out.println("종료입니다.");
		sc.close();

	}// main
}
