package com.tj.ex;

import java.util.*;

public class Example {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int math, english, korean;
		System.out.println("수학점수는?");
		math = sc.nextInt();
		System.out.println("국어점수는?");
		korean = sc.nextInt();
		System.out.println("영어점수는?");
		  english = sc.nextInt();
		  sc.close();

//		int math = 90;
//		int english = 85;
//		int korean = 89;
		double sum = math + english + korean;
		float average = (math + english + korean) / 3.0f;

		System.out.println("국어= " + korean + "점");
		System.out.println("수학= " + math + "점");
		System.out.println("영어= " + english + "점");
		System.out.printf("총합= %3.0f점", sum);
		System.out.printf("\n평균= %5.2f점\n", average);

		if (average >= 90)
			System.out.println("A등급입니다.");
		else if (average >= 80)
			System.out.println("B등급입니다.");
		else if (average >= 70)
			System.out.println("C등급입니다.");
		else
			System.out.println("이번 학기는 망했군요. 재수강입니다.");

	}
}
