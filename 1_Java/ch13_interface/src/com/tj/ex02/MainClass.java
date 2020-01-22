package com.tj.ex02;

public class MainClass {

	public static void main(String[] args) {
		S s1 = new C(); //1.객체(변수)의 타입 다형성
		
		s1.method();
		
		C c1 = new C();
		
		c1.method();
		
		S s2 = new S();
		
		s1.method(); // C의 method() . 오버라이딩
		
		s2.method(); // S의 method()
		
		s2.method();
		System.out.println("오버로딩 다형성 예제");
		s2.method();
		s2.method(10);
		s1.method();
		s1.method(10);
		

	}

}
