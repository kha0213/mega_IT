package com.tj.ex6_wrapper;

import com.tj.ex4_object.Card;

public class Ex02 {
	public static void main(String[] args) {
		
		Integer obj1 = 10; // Integer obj1 = new Integer(10);
		Integer obj2 = 10; // Integer obj2 = new Integer(10);
		
		int total=obj1+obj2;
		
		Card c = new Card('¢Ý', 10);
		int i=10;
		
		boolean b = true;
		Boolean bObj = true;

		System.out.println(c.equals(obj1));
		System.out.println(c.equals(i));
		System.out.println(c.equals(b));
		System.out.println(c.equals(bObj));
		System.out.println(c.equals(true));
		
		int longlong = Integer.parseInt("123");
		System.out.println(longlong);
		
		
		
	}
}
