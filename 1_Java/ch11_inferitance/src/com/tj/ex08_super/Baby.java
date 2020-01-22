package com.tj.ex08_super;

public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 Baby생성자 호출됨");
	}
	public Baby(String name,String character) {
		
//		setName(name);
//		setCharacter(character);
		super(name,character); // super() ; 내 클래스의 슈퍼단의 생성자 함수
		System.out.println("매개변수 2개짜리 Baby");
	}
	@Override
	public void intro() {
		//super. : 객 클래스의 슈퍼단의
		System.out.println("애기이이");
		super.intro(); 
	}
}
