package com.tj.ex;

public class Ex01 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i<11;i++) {
			sum +=i;
		}
		System.out.println("1���� 10���� �������� "+sum);
		System.out.println((sum%2==0) ? "¦���Դϴ�." : "Ȧ���Դϴ�.");
		
		
		sum=0;
		for(int i=10; i<=100; i++) {
			sum += i;
		}
		System.out.println("10���� 100���� ��������"+sum);
		

		
		
	}

}
