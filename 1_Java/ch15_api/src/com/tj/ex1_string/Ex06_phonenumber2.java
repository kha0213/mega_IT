package com.tj.ex1_string;

import java.util.Scanner;

public class Ex06_phonenumber2 {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-7777","02-325-6666","02-3333-9999","010-5054-9999" };
		Scanner sc = new Scanner(System.in);
		String searchTel;
		int idx;
		boolean searchOk = false;
		do {
			System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ��� ? / �׸��ν÷��� x�� �����ּ���.");
			searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x")) {
				break;
			}
			for (idx = 0; idx < tels.length; idx++) {
				String temp = tels[idx].substring(tels[idx].lastIndexOf('-') + 1);

				if (searchTel.equals(temp)) {
					System.out.println("�˻��Ͻ� ȸ���� ��ȭ��ȣ�� " + tels[idx] + "�Դϴ�.");
					searchOk = true;					
				}

			}
			if (!searchOk) {
				System.out.println("�ش� ȸ���� ������ ã�� �� �����ϴ�.");
			}
		} while (true);
		System.out.println("�̿����ּż� �����մϴ�.");

		sc.close();
	}//main
}