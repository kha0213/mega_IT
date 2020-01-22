package com.tj.ex;

public class Var_ex07 {
	public static void main(String[] args) {
		byte b = 10;
		double d = 10;  // d= 10.0 묵시적 형변환
		double d2 = 10.91;  
		int i = (int)d2; // 명시적 형변환 - 데이터 손실 있을 수 있음
		d2 = (10+20+30)/7;
		System.out.println(d+b);
		
		System.out.println(d2);
		System.out.println(i);
	}
}
