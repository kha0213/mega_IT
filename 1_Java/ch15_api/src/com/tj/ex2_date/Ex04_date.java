package com.tj.ex2_date;

import java.util.Date;

public class Ex04_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date); // KST �� �ڸ���Ÿ��
//		int year = date.getYear() + 1900;
//		int month = date.getMonth() + 1;
//		int day = date.getDate();
//		int hour = date.getHours();
//		int minute = date.getMinutes();
//		int second = date.getSeconds();
//		System.out.printf("%d�� %d�� %d�� %d�� %d�� %d��\n", year, month, day, hour, minute, second);

		System.out.printf("%tY�� %tm�� %td��  %ta���� %tH��  %tM�� %tS��\n", date, date, date, date, date, date, date);
		// %tY�� %tm�� %td�� %ta���� %tH:24�� %tM�� %tS:��
		System.out.printf("%1$tY�� %1$tm�� %1$td��  %1$ta���� %1$tH��  %1$tM�� %1$tS��\n", date);
	}

}
