package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex10 {
	public static void main(String[] args) {
		Date date = new Date(new GregorianCalendar().getTimeInMillis());
		SimpleDateFormat[] sdf = {new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("yyyy-M-d"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS"),
				new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss:SS"),
				new SimpleDateFormat("yyyy-MM-dd E���� a hh:mm:ss:SS"),
				new SimpleDateFormat("������ ������ D��° ���Դϴ�."),
				new SimpleDateFormat("������ �̴��� W��° ���Դϴ�."),
				new SimpleDateFormat("������ ������ w��° ���Դϴ�.")};
		
		for(SimpleDateFormat s : sdf) {
			System.out.println(s.format(date));
		}//for
	}
//�� Date Ŭ����
//	��¥�� ǥ���ϴ� Ŭ����
//	��¥ ������ ��ü���� �ְ� ���� �� �ַ� ���
}