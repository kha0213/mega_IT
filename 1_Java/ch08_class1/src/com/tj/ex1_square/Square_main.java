package com.tj.ex1_square;

public class Square_main {
	public static void main(String[] args) {

		Square s1 = new Square();
		s1.setSide(6);
		Square s2 = new Square(10);
		System.out.println(s1.area());
		System.out.println(s2.getSide());

	}

}
