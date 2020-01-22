package com.tj.op;

import java.util.*;
// 입력한 두수를 비교연산자들을 이용하여 비교한 결과가 true면 O false면 X를 출력하시오.
public class Example2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("첫 번째 수를 입력하세요");
		int num1 = scanner.nextInt();
		System.out.println("두 번째 수를 입력하세요");
		int num2 = scanner.nextInt();
		
		System.out.println("두 수가 같나요?");
		System.out.println(num1==num2? "O":"X");
		

		scanner.close();
	

	}

}
