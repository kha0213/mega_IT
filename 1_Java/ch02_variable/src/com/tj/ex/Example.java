package com.tj.ex;

import java.util.*;

public class Example {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int math, english, korean;
		System.out.println("����������?");
		math = sc.nextInt();
		System.out.println("����������?");
		korean = sc.nextInt();
		System.out.println("����������?");
		  english = sc.nextInt();
		  sc.close();

//		int math = 90;
//		int english = 85;
//		int korean = 89;
		double sum = math + english + korean;
		float average = (math + english + korean) / 3.0f;

		System.out.println("����= " + korean + "��");
		System.out.println("����= " + math + "��");
		System.out.println("����= " + english + "��");
		System.out.printf("����= %3.0f��", sum);
		System.out.printf("\n���= %5.2f��\n", average);

		if (average >= 90)
			System.out.println("A����Դϴ�.");
		else if (average >= 80)
			System.out.println("B����Դϴ�.");
		else if (average >= 70)
			System.out.println("C����Դϴ�.");
		else
			System.out.println("�̹� �б�� ���߱���. ������Դϴ�.");

	}
}
