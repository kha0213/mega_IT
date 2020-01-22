package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class Ex02_gc {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		int year = gc.get(GregorianCalendar.YEAR); // 2019
		int month = gc.get(GregorianCalendar.MONTH) + 1; // 0,1,2...11��
		int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int week = gc.get(GregorianCalendar.DAY_OF_WEEK); // ��:1 ��:2 ȭ:3 ��:4... ��:7
		int hour24 = gc.get(GregorianCalendar.HOUR_OF_DAY);
		int ampm = gc.get(GregorianCalendar.AM_PM); // am pm (0 or 1)
		int hour = gc.get(GregorianCalendar.HOUR); // 12 �ð�����
		int minute = gc.get(GregorianCalendar.MINUTE);
		int second = gc.get(GregorianCalendar.SECOND);
		int milliSec = gc.get(GregorianCalendar.MILLISECOND);

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
