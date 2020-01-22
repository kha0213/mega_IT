package com.tj.ex2_date;

import java.util.*;


public class Ex05 {
	public static void main(String[] args) {
		//����
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��\n", calNow);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��\n", gcNow);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��\n", dateNow);
		//Ư���� ����(1990.12.11)
		GregorianCalendar gcThat = new GregorianCalendar(1990, 11, 11);
		Date dateThat1 = new Date(90, 11, 11);
		Date dateThat2 = new Date(gcThat.getTimeInMillis());
		Date dateThat3 = new Date(new GregorianCalendar(1990, 11, 11).getTimeInMillis());
		
		System.out.printf("%1$tY�� %1$tm�� %1$td�� \n", gcThat);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� \n", dateThat1);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� \n", dateThat2);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� \n", dateThat3);
		
	}
}
