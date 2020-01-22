package com.tj.ex1_string;

public class Ex04 {
	public static void main(String[] args) {
		String str = "2002 WorldCup Korea";
		System.out.println("정상문자열 : "+str);
		System.out.print("문자열 뒤집기 : ");
		//짝수 번째 문자열 출력
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		
		System.out.print("짝수번째 문자열 : ");
		for(int j=0;j<str.length();j++) {
			if(j%2!=0) {
			System.out.print(str.charAt(j));
			}else {
				System.out.print(' ');
			}
		}
		
		
	}
}
