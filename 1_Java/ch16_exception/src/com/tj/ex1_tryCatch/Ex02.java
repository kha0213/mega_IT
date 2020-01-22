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
				System.out.println("ù ��° �� i�� �Է��ϼ���.");
				i = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("ù ��° ���� �� ���ڸ� �־��ּ���.");
				sc.nextLine(); // ���۸� ����
			}
		} while (true);

		System.out.println("�� ��° �� j�� �Է��ϼ���.");
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
				System.out.println("���ڳ����� �ȵſ�.");
		}catch (Exception e) {
//			e.printStackTrace(); ���� ���� �޼���
			System.out.println(e.getClass().getSimpleName());
				System.out.println(e.getMessage());
				System.out.println("0���� ������ �� �ȵǿ�.");
		}
		System.out.println("DONE");
		sc.close();
	}
}
