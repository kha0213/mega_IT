package com.tj.ex7.today;

import java.util.Scanner;

public class Grade_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Grade[] per = new Grade[3];
		per[0] = new Grade("�迵��",80,94,70);
		per[1] = new Grade("���й�",30,45,50);
		per[2] = new Grade("�ּ���",45,50,60);
		
		
		for(int i=0;i<32;i++) {
		System.out.print("*");}
		System.out.println();
		
		System.out.println("�̸�      ����       ����       ����       ����       ���");
		
		for(int i=0;i<32;i++) {
			System.out.print("*");}
		System.out.println();
		for(Grade idx : per) {
			idx.print();
		}
		sc.close();
	}//main

}
