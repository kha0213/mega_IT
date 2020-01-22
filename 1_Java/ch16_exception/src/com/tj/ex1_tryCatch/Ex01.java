package com.tj.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int j;
		do {
			try {
				System.out.println("첫 번째 수 i를 입력하세요.");
				i = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("첫 번째 수에 꼭 문자를 넣어주세요.");
				sc.nextLine(); // 버퍼를 지워
			}
		} while (true);

		System.out.println("두 번째 수 j를 입력하세요.");
		j = sc.nextInt();

		try {
			j = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			j = 1;
		}

		System.out.println("i= " + i + "\tj=" + j);
		System.out.println("i+j = " + (i + j));
		try {
			System.out.println("i/j = " + (i / j));
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
//			e.printStackTrace(); 예외 오류 메세지
			System.out.println(e.getMessage());
			System.out.println("0으로 나누지 않고 우회합니다.");
		}
		System.out.println("i-j = " + (i - j));
		System.out.println("i*j = " + (i * j));
		System.out.println("DONE");
		sc.close();
	}
}
