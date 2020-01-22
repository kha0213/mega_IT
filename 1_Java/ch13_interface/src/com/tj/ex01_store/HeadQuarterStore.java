package com.tj.ex01_store;
//interface : 추상메소드와 public 상수만 가지고 있음
public interface HeadQuarterStore {

//	public static final double PI = 3.1415926535;
	public double PI = 3.1415926535; //static final 생략 가능
	
	public void kimchi(); // 추상메소드 : 메소드 선언부만 있는 메소드(구현부는 없음)

	public void bude();

	public void bibib();

	public void sunde();

	public void gonggibab(); // abstract 생략가능

	
}
