package com.tj.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int i = 10, j = 20, hap = 30;
		if(i+j == hap) {
			System.out.println("i+j는 hap입니다");			
		}//main함수 끝
		if(i>j) {
			System.out.println("i는 j보다 크다");
		}
		else {
			System.out.println("i는 j보다 크지 않다");
		}
	}
}
