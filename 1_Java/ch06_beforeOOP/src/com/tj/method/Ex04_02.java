package com.tj.method;

import java.util.*;

public class Ex04_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int su;

		do {
			System.out.println("���丮�� ��� \n �� !�� �Ի��ұ��? (0���� ū ���� �Է��ϼ���)");
			su = sc.nextInt();
		} // do
		while (su <= 1);
		long result = factorial(su);
		System.out.println(su + "!=" + result);
		sc.close();
	}// main

	private static long factorial(int su) {
		if (su==1) {
			return 1;
		}
		else {
			
		return su*factorial(su-1);
		}
	}

//	static long factorial(int su) {
//		long result = 1;
//		for (int i = su; i > 0; i--) {
//
//			result *= i;
//		}//for
//		return result;
//
//	}// factorial
	
	

}
