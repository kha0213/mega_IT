package com.tj.condition;

import java.util.*;

public class Ex05_switch2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 수?");
		int num = sc.nextInt();
		sc.close();
		switch(num%2) {
		case 0:
		System.out.println("짝수를 입력하셨군요"); break;
		default : System.out.println("홀수를 입력하셨군요");
		}
	}

}
