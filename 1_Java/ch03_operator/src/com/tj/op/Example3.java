package com.tj.op;

import java.util.*;

public class Example3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요?");
		int age = scanner.nextInt();
		scanner.close();

		if (age >= 65) {
			System.out.println("경로우대");
		} else {
			System.out.println("일반");
		}

	}

}
