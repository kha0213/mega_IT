package com.tj.loop;
import java.util.*;
public class Ex07_while {
	public static void main(String[] args) {
		System.out.println("짝수를 입력할 때까지 계속 할껍니다아아아");
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		do {
			System.out.println("짝수를 입력하세요");
			num = sc.nextInt();
		}
		while(num%2!=0);
		System.out.println("잘하셨네요 짝수"+num+"를 입력했네요");
		sc.close();
	}

}
