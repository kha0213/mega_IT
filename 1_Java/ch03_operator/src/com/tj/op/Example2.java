package com.tj.op;

import java.util.*;
// �Է��� �μ��� �񱳿����ڵ��� �̿��Ͽ� ���� ����� true�� O false�� X�� ����Ͻÿ�.
public class Example2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("ù ��° ���� �Է��ϼ���");
		int num1 = scanner.nextInt();
		System.out.println("�� ��° ���� �Է��ϼ���");
		int num2 = scanner.nextInt();
		
		System.out.println("�� ���� ������?");
		System.out.println(num1==num2? "O":"X");
		

		scanner.close();
	

	}

}
