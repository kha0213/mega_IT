package com.tj.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("int ���� : "+random.nextInt());
		System.out.println("0�� 1���� double ���� : "+random.nextDouble());
		System.out.println("T/F ���� : "+random.nextBoolean());
		System.out.println("0~100���� ������ ���� "+random.nextInt(101));
		System.out.println("0~44���� ���� ���� : "+random.nextInt(45));
		System.out.println("1~45���� ���� ���� : "+(random.nextInt(45)+1));
		
	 

	}
}
