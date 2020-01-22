package com.tj.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("int 난수 : "+random.nextInt());
		System.out.println("0과 1사이 double 난수 : "+random.nextDouble());
		System.out.println("T/F 난수 : "+random.nextBoolean());
		System.out.println("0~100까지 정수인 난수 "+random.nextInt(101));
		System.out.println("0~44까지 정수 난수 : "+random.nextInt(45));
		System.out.println("1~45까지 정수 난수 : "+(random.nextInt(45)+1));
		
	 

	}
}
