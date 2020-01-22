package com.tj.condition;

import java.util.Scanner;

// 두 수를 입력받아 몇 번째 수가 더 큰지 그리고 그 큰 수를 출력
public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수는?");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수는?");
		int num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.println("첫 번째 입력한 값 (" + num1 + ")이 더 커");
		} else if (num1 < num2) {
			System.out.println("두 번째 입력한 값 (" + num2 + ")이 더 커");
		} else {
			System.out.println("두 수는 같아");
		}
		sc.close();
	}

}
