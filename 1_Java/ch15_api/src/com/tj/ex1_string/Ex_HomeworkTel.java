package com.tj.ex1_string;

import java.util.Scanner;

public class Ex_HomeworkTel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String phoneNum;
		while (true) {
			System.out.println("��ȣ�� �Է��ϼ���(-������ ����)\n���� ������ ����ص����~ �׸��ν÷��� x�� �Է��ϼ���.");
			phoneNum = sc.next();
			if (phoneNum.equalsIgnoreCase("x")) {
				System.out.println("�ý����� �����մϴ�. �ȳ��� �輼��.");
				break;
			}
			
			if(phoneNum.indexOf('-')==-1) {
				System.out.println("������ - �� �Է����ּ���.");
				continue;
			}
			if(phoneNum.indexOf('-')==phoneNum.lastIndexOf('-')) {
				System.out.println("������ - �� 2�� �ʿ��ؿ�~!");
				continue;
			}
			if(phoneNum.length()<=11) {
				System.out.println("��ȭ��ȣ�� �ʹ� ª��!! ����� �Է���.");
				continue;
			}
			if(phoneNum.length()>=14) {
				System.out.println("��ȭ��ȣ�� �ʹ� ���!! ����� �Է���.");
				continue;
			}
			
			
			System.out.println("�Է��� ��ȭ��ȣ: " + phoneNum + " �Դϴ�.");
			System.out.print("¦����° ���ڿ�: ");
			for (int i = 0; i < phoneNum.length(); i++) {
				if (i % 2 != 0) {
					System.out.print(phoneNum.charAt(i));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" �Դϴ�.");
			System.out.print("���ڸ� �Ųٷ�: ");
			for (int i = phoneNum.length() - 1; i >= 0; i--) {
				System.out.print(phoneNum.charAt(i));
			} // for
			System.out.println(" �Դϴ�.");
			System.out.println("��ȭ��ȣ ���ڸ���: " + phoneNum.substring(0, phoneNum.indexOf('-')));
			System.out.println("��ȭ��ȣ ���ڸ���: " + phoneNum.substring(phoneNum.lastIndexOf('-') + 1));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		sc.close();

	}

}
