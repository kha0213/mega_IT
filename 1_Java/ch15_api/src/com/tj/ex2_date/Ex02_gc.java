package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class Ex02_gc {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		int year = gc.get(GregorianCalendar.YEAR); // 2019
		int month = gc.get(GregorianCalendar.MONTH) + 1; // 0,1,2...11월
		int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int week = gc.get(GregorianCalendar.DAY_OF_WEEK); // 일:1 월:2 화:3 수:4... 토:7
		int hour24 = gc.get(GregorianCalendar.HOUR_OF_DAY);
		int ampm = gc.get(GregorianCalendar.AM_PM); // am pm (0 or 1)
		int hour = gc.get(GregorianCalendar.HOUR); // 12 시간단위
		int minute = gc.get(GregorianCalendar.MINUTE);
		int second = gc.get(GregorianCalendar.SECOND);
		int milliSec = gc.get(GregorianCalendar.MILLISECOND);

		System.out.printf("현재시간 %d년 %d월 %d일 ", year, month, day);
		switch (week) {
		case 1:
			System.out.print("일요일 ");
			break;
		case 2:
			System.out.print("월요일 ");
			break;
		case 3:
			System.out.print("화요일 ");
			break;
		case 4:
			System.out.print("수요일 ");
			break;
		case 5:
			System.out.print("목요일 ");
			break;
		case 6:
			System.out.print("금요일 ");
			break;
		case 7:
			System.out.print("토요일 ");
			break;
		default:
			break;
		}
		System.out.print((ampm == 0) ? "오전 " : "오후 ");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, milliSec);
		System.out.printf("현재시간 %d년 %d월 %d일 ", year, month, day);
		System.out.printf("24시간 단위 : %d시 %d분 %d초 %d\n ", hour24, minute, second, milliSec);
	}
}
