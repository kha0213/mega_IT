package com.tj.ex4_object;

public class Ex03_equals {
	public static void main(String[] args) {
		Person p1 = new Person("9001111055955");
		Person p2 = new Person("9001111055955");
		Sawon p3 = new Sawon("a01", "홍");
		
		System.out.println((p1.equals(p2))? "같은사람" : "다른사람");
		
		boolean b = p1.getJuminNo()==p2.getJuminNo();
		System.out.println(b);
		
		
		
	}
}
