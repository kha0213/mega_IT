package com.tj.ex5_library;

import java.text.SimpleDateFormat;
import java.util.*;

public class ExDayCount {
	public static void main(String[] args) {
		//Date checkOutDate = new Date(119, 10, 13); //2019,11,13���� ����
		Date checkOutDate = new Date(new GregorianCalendar(2019,10,13).getTimeInMillis()); //2019,11,13���� ����
		Date now = new Date();
		long checkOutMillis = checkOutDate.getTime(); // 1970.1.1~2019.11.13���� �и�����
		long nowMillis = now.getTime(); // 1970.1.1~2019.12.13���� �и�����
		long diff = nowMillis - checkOutMillis; //���������� �и�����
		long day = diff/(24*60*60*1000);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(checkOutDate));
		System.out.println(sdf.format(now));
		System.out.println(day);
		
		if(day>14) {
			System.out.println((day-14)*100+"�� ��ü�Ḧ ���ž� �ݳ�ó�� �����մϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�Ḧ �����̳���?Y/N (N:�ݳ��ߴ�)");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.exit(0); // checkIn method������ return���� ��ü
			}
		}
		
		System.out.println("�ݳ�ó������");
		
	}
}

