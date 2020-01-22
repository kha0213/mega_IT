package com.tj.ex4_object;

public class Ex05_hashCode {
	public static void main(String[] args) {
		Card c1 = new Card('♥',8);
		Card c2 = new Card('♥',8);
		
		System.out.println("c1과 c2가 주소가 같냐? "+(c1==c2));
		System.out.println("c1과 c2가 같은 카드냐? "+c1.equals(c2));
		System.out.println("c1의 해쉬코드 "+c1.hashCode());
		System.out.println("c2의 해쉬코드 "+c2.hashCode());
		
	}
}
