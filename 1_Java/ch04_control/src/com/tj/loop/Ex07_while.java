package com.tj.loop;
import java.util.*;
public class Ex07_while {
	public static void main(String[] args) {
		System.out.println("¦���� �Է��� ������ ��� �Ҳ��ϴپƾƾ�");
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		do {
			System.out.println("¦���� �Է��ϼ���");
			num = sc.nextInt();
		}
		while(num%2!=0);
		System.out.println("���ϼ̳׿� ¦��"+num+"�� �Է��߳׿�");
		sc.close();
	}

}
