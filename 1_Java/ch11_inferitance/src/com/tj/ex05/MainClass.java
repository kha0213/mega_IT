package com.tj.ex05;



public class MainClass {
	public static void main(String[] args) {
//		Super s = new Super();
//		System.out.println(s.s);
		Child1 c1 = new Child1(5);
		System.out.println(c1.s);
		GrandChild gc = new GrandChild();
		System.out.println("gc.s="+gc.s);
		System.out.println("gc.c1="+gc.c1);
//ºÒ°¡´É 	System.out.println("gc.c2="+gc.c2); 
		
		
	}

}
