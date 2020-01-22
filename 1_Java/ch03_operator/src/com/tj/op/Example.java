package com.tj.op;

import java.util.*;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		sc.close();

		System.out.println("수를 입력하세요");
		num = sc.nextInt();
		if (num % 2 == 0)
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");

	}

}
