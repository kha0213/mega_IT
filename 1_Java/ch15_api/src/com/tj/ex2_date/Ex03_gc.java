package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class Ex03_gc {
	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar();
		System.out.println("1970�� 1�� 1�� 0�� 0�� 0�ʺ��� ���ݱ����� �и������� ������ ����.");
		System.out.println(System.currentTimeMillis());
		System.out.println(gcNow.getTimeInMillis()); //1970.1.1~ gc���������� �и�����
		GregorianCalendar gcThat = new GregorianCalendar(2019, 10, 25, 9, 30, 0);
		System.out.println(gcThat.getTimeInMillis());
		
	}

}
