package com.tj.ex1_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// x�� ������ ���� ������ ����� ���ѹݺ�
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("���ϴ� ��ɹ�ȣ�� 1.����, 2.�ݳ�, x:����");
			fn = sc.next();
			if(fn.equalsIgnoreCase("x")) {
				break;
			}
			if (fn.equals("1")) {
				System.out.println("�����Դϴ�.");
			} else if (fn.equals("2")) {
				System.out.println("�ݳ��Դϴ�.");
			} else {
				System.out.println("�߸� �Է��ؽ�");
			}

		} while (true);
		System.out.println("�����Դϴ�.");
		sc.close();

	}// main
}
