package com.tj.ex3_math;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.12�� �ݿø� : "+Math.round(9.12));
		System.out.println("9.12�� �ø� : "+Math.ceil(9.12));
		System.out.println("9.12�� ���� : "+Math.floor(9.12));
		
		System.out.println("9.56�� �Ҽ��� ���ڸ����� �ݿø� : "+Math.round(9.56*10)/10.0);
		
		// 9.567�� �Ҽ��� ��°¥������ �ݿø��Ͽ���.
		System.out.println("9.567�� �ݿø� : "+Math.round(9.567*100)/100.0);
		
		System.out.println("9.56�� �Ҽ��� ���ڸ����� �ø� : "+Math.ceil(9.56*10)/10);
		System.out.println("9.56�� �Ҽ��� ���ڸ����� ���� : "+Math.floor(9.56*10)/10);
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("19�� ���� �ڸ����� �ݿø�"+Math.round(19/10.0)*10);
		System.out.println("19�� ���� �ڸ����� �ø� "+Math.ceil(19/10.0)*10);
		System.out.println("19�� ���� �ڸ����� ���� "+Math.floor(19/10.0)*10);
		
		
	}
}
