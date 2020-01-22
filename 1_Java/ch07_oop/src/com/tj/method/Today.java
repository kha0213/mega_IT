package com.tj.method;

import java.util.Scanner;

public class Today {
	public static void main(String[] args) {
		int you;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("구구단을 계산해줄께요 2~9 사이의 정수를 입력하세요!");
			you = sc.nextInt();
			if (you < 2 || you > 9) {
				System.out.println("때끼!! 수를 똑바로 입력해야지 2~9 사이의 정수를 입력해!!");
			} else {
				break;
			} // else
		} // while
		sc.close();
		
		Practice gu = new Practice();

		gu.guguPrint(you);

	}// main메서드 _사용자로부터 2~9까지의 구구단을 받는다.

//	private static void guguPrint(int value) {// 사용자로부터 받은 수(value)의구구단을 출력
//		System.out.println("**" + value + "단**");
//		for (int i = 1; i < 10; i++) {
//			System.out.println(value + "X" + i + "=" + value * i);
//
//		}
//	}// guguPrint
}// class

