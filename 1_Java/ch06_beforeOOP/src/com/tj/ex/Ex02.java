package com.tj.ex;
// methodȭ - sum(1,10) 1~10���� ������, evenOdd(500)-> ��ȣ ���� ���� ¦������ Ȧ������ �Ǻ��ϴ� ���α׷�
public class Ex02 {
	public static void main(String[] args) {
		int sum= sum(10);
	
		System.out.println("1���� 10���� �������� "+sum);
//		System.out.println((sum%2==0) ? "¦���Դϴ�." : "Ȧ���Դϴ�.");
		System.out.println(evenOdd(sum));
		
		
		sum = sum(10,100);
		
		System.out.println("10���� 100���� ��������"+sum);
		System.out.println(evenOdd(sum));
		


	}
	private static int sum(int to) {
		int result = 0;
				
		for(int i=1;i<=to;i++) {
			result +=i;
		}
		return result;
	}//sum method
			
	private static int sum(int from, int to) {
		int result = 0;
				
		for(int i=from;i<=to;i++) {
			result +=i;
		}
		return result;
		
	}//sum method
			
	private static String evenOdd(int value) {
		
		String result = value%2==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
	
		return result;
	}//evenOdd

}
