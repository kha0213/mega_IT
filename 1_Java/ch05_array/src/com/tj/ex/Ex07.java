package com.tj.ex;
// �Ϲ� for V s. Ȯ�� for

public class Ex07 {
	public static void main(String[] args) {
		String[] names = { "ȫ�浿", "��浿", "������" };
		// �Ϲ� for

		for (int i = 0; i < names.length; i++) {
			System.out.println(i + 1 + "��° ����� �̸��� " + names[i] + "�Դϴ�.");
		}
		// Ȯ�� for �� - (�迭,�÷���) ��¸� �� �� �ַ� ��
		// �迭Ÿ�� �ӽú��� : �迭or�÷���
		for(String n : names) {
			System.out.println(n);
		}
		
		
		
		
		
		
	}
	
	
	

}
