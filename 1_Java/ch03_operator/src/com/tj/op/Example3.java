package com.tj.op;

import java.util.*;

public class Example3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���?");
		int age = scanner.nextInt();
		scanner.close();

		if (age >= 65) {
			System.out.println("��ο��");
		} else {
			System.out.println("�Ϲ�");
		}

	}

}
