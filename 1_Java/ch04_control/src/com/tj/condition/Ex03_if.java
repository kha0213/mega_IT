package com.tj.condition;

import java.util.Scanner;

// �� ���� �Է¹޾� �� ��° ���� �� ū�� �׸��� �� ū ���� ���
public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ����?");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ����?");
		int num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.println("ù ��° �Է��� �� (" + num1 + ")�� �� Ŀ");
		} else if (num1 < num2) {
			System.out.println("�� ��° �Է��� �� (" + num2 + ")�� �� Ŀ");
		} else {
			System.out.println("�� ���� ����");
		}
		sc.close();
	}

}
