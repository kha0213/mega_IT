package com.yl.practice;

import java.util.Scanner;

public class Reverse_And_Add {
	public static void main(String[] args) {
		StringBuilder sb;
		Scanner sc = new Scanner(System.in);
		
		int count=0;
		int num;
		System.out.println("�����Է��ϼ���.");
		num=sc.nextInt();
		
		while(true) {
			sb = new StringBuilder(num+"");
			sb.reverse();
			String temp=sb.substring(0);
			
			if(Integer.parseInt(temp)==num) {
				break;
			}else {
				num+=Integer.parseInt(temp);
				
				count++;
			}
		}
		System.out.println("Ƚ���� "+count);
		System.out.println("ȸ���� "+num);
		
		
	}
}
