package com.tj.ex;
// Arithmetic���� sum, evenOdd, abs method Ȱ�� 

import com.tj.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10,100);
		System.out.println(tot+"�̰� ���̰�"+ar.evenOdd(tot));
		System.out.println("-5�� ���밪�� "+Arithmetic.abs(-5) );
		System.out.println(ar.abs(-5));
	
	
	}

}
