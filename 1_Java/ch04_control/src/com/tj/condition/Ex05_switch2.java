package com.tj.condition;

import java.util.*;

public class Ex05_switch2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� ��?");
		int num = sc.nextInt();
		sc.close();
		switch(num%2) {
		case 0:
		System.out.println("¦���� �Է��ϼ̱���"); break;
		default : System.out.println("Ȧ���� �Է��ϼ̱���");
		}
	}

}
