package com.tj.ex;
// Arithmetic안의 sum, evenOdd, abs method 활용 

import com.tj.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10,100);
		System.out.println(tot+"이게 합이고"+ar.evenOdd(tot));
		System.out.println("-5의 절대값은 "+Arithmetic.abs(-5) );
		System.out.println(ar.abs(-5));
	
	
	}

}
