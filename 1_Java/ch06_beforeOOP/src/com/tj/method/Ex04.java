package com.tj.method;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int su;
		
		
		do {
			System.out.println("���丮�� ��� \n �� !�� �Ի��ұ��? (0���� ū ���� �Է��ϼ���)");
			su = sc.nextInt();
		} // do
		while (su <= 0);
		sc.close();
		long result = factorial(su);
		System.out.println(su + "!=" + result);
	}// main

	static long factorial(int su) {
		long result = 1;
		for (int i = su; i > 0; i--) {

			result *= i;
		}//for
		return result;
		

	}// factorial

}
