package com.tj.ex2_date;

import java.util.Calendar;

public class Ex01_calendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(); // �̱��� Ŭ���� ��ü
//		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR); // 2019
		int month = calendar.get(Calendar.MONTH) + 1; // 0,1,2...11��
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int week = calendar.get(Calendar.DAY_OF_WEEK); // ��:1 ��:2 ȭ:3 ��:4... ��:7
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
		int ampm = calendar.get(Calendar.AM_PM); // am pm (0 or 1)
		int hour = calendar.get(Calendar.HOUR); // 12 �ð�����
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int milliSec = calendar.get(Calendar.MILLISECOND);

		System.out.printf("����ð� %d�� %d�� %d�� ", year, month, day);
		switch (week) {
		case 1:
			System.out.print("�Ͽ��� ");
			break;
		case 2:
			System.out.print("������ ");
			break;
		case 3:
			System.out.print("ȭ���� ");
			break;
		case 4:
			System.out.print("������ ");
			break;
		case 5:
			System.out.print("����� ");
			break;
		case 6:
			System.out.print("�ݿ��� ");
			break;
		case 7:
			System.out.print("����� ");
			break;
		default:
			break;
		}
		System.out.print((ampm == 0) ? "���� " : "���� ");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, minute, second, milliSec);
		System.out.printf("����ð� %d�� %d�� %d�� ", year, month, day);
		System.out.printf("24�ð� ���� : %d�� %d�� %d�� %d\n ", hour24, minute, second, milliSec);
	}
}
