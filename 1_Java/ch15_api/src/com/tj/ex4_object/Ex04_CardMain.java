package com.tj.ex4_object;

public class Ex04_CardMain {
	public static void main(String[] args) {
		Card c1 = new Card('��',2);
		Card c2 = new Card('��',2);
		Card c3 = new Card('��',6);
		
		
		System.out.println("c1�� c2�� ����? "+c1.equals(c2));
		System.out.println("c1�� c3�� ����? "+c1.equals(c3));
		System.out.println(c2);
		System.out.println(c3);
		
		
	}//main

}
