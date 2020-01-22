package com.tj.ex;
// method화 - sum(1,10) 1~10까지 누적합, evenOdd(500)-> 괄호 안의 수가 짝수인지 홀수인지 판별하는 프로그램
public class Ex02 {
	public static void main(String[] args) {
		int sum= sum(10);
	
		System.out.println("1부터 10까지 누적합은 "+sum);
//		System.out.println((sum%2==0) ? "짝수입니다." : "홀수입니다.");
		System.out.println(evenOdd(sum));
		
		
		sum = sum(10,100);
		
		System.out.println("10부터 100까지 누적합은"+sum);
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
		
		String result = value%2==0 ? "짝수입니다." : "홀수입니다.";
	
		return result;
	}//evenOdd

}
