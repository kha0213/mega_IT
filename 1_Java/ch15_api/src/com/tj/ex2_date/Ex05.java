package com.tj.ex2_date;

import java.util.*;


public class Ex05 {
	public static void main(String[] args) {
		//현재
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", calNow);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", gcNow);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", dateNow);
		//특정한 시점(1990.12.11)
		GregorianCalendar gcThat = new GregorianCalendar(1990, 11, 11);
		Date dateThat1 = new Date(90, 11, 11);
		Date dateThat2 = new Date(gcThat.getTimeInMillis());
		Date dateThat3 = new Date(new GregorianCalendar(1990, 11, 11).getTimeInMillis());
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 \n", gcThat);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 \n", dateThat1);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 \n", dateThat2);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 \n", dateThat3);
		
	}
}
