package com.tj.ex;
// 일반 for V s. 확장 for

public class Ex07 {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김길동", "김제동" };
		// 일반 for

		for (int i = 0; i < names.length; i++) {
			System.out.println(i + 1 + "번째 사람의 이름은 " + names[i] + "입니다.");
		}
		// 확장 for 문 - (배열,컬렉션) 출력만 할 때 주로 씀
		// 배열타입 임시변수 : 배열or컬렉션
		for(String n : names) {
			System.out.println(n);
		}
		
		
		
		
		
		
	}
	
	
	

}
