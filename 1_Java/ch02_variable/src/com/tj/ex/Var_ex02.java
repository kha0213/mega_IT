package com.tj.ex;

public class Var_ex02 {
	public static void main(String[] args) {
		int i = 10; // 4bite짜리 i라는 주머니에 10을 할당(대입)
		byte j = 20;
		double h = 0.1; 
		i=5;
		 
		System.out.println("i="+i+"\t j="+j+"\t h="+h);
		// 따옴표 안의 \n = 줄바꿈 , \t = 탭만큼 띄어쓰기
		
		char c1 = 'A';
		char c2 = 'B';
		System.out.print("c1="+c1+"\t c2="+c2+"\n");
		System.out.printf("c1=%d\t c2%d\n", (int)c1, (int)c2);
		// %c - 문자, %d - 정수, %f - 실수, %s - 문자열
		
		System.out.println("\n프로그램 끝");
		
	}

}
