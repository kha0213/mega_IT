package com.tj.condition;
//점수입력받아 학점 출력(if, switch문)
import java.util.*;
public class Ex04_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 점수를 입력하세요.");
		int score = sc.nextInt();
		
		if(90<=score && score<=100) {
			System.out.println("A등급");
		}
		else if(80<=score && score<=90) {
			System.out.println("B등급");
		}
		else if(70<=score && score<=80) {
			System.out.println("C등급");
		}
		else if(60<=score && score<=90) {
			System.out.println("D등급");
		}
		else if(0<=score && score<=60) {
			System.out.println("F등급");
		}
		else {
			System.out.println("유효하지 않은 점수입니다.");
		}
		
		sc.close();
		
	}

}
