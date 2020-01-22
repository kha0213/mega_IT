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
//			e.printStackTrace(); ���� ���� �޼���
			System.out.println(e.getMessage());
			System.out.println("0���� ������ �ʰ� ��ȸ�մϴ�.");
		}
		System.out.println("i-j = " + (i - j));
		System.out.println("i*j = " + (i * j));
		System.out.println("DONE");
		sc.close();
	}
}
