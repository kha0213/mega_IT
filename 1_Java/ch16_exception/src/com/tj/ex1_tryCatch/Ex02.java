package com.tj.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int j=1;
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
		try {
			j = sc.nextInt();     //InputMismatchException
			System.out.println("i= " + i + "\tj=" + j);
			System.out.println("i+j = " + (i + j));
			System.out.println("i-j = " + (i - j));
			System.out.println("i*j = " + (i * j));
			System.out.println("i/j = " + (i / j)); //ArithmeticException
		}catch (InputMismatchException e) {
			System.out.println(e.getClass().getSimpleName());
				System.out.println(e.getMessage());
				System.out.println("문자넣으면 안돼요.");
		}catch (Exception e) {
//			e.printStackTrace(); 예외 오류 메세지
			System.out.println(e.getClass().getSimpleName());
				System.out.println(e.getMessage());
				System.out.println("0으로 나누는 건 안되요.");
		}
		System.out.println("DONE");
		sc.close();
	}
}
