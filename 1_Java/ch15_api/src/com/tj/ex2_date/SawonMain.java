package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class SawonMain {
	public static void main(String[] args) {
		Sawon1[] sawon = {new Sawon1("A2001", "�շ���", Sawon1.COMPUTER,1990,12,11),
				new Sawon1("B1901", "������", Sawon1.DESIGN),
				new Sawon1("A1001", "�ٷ���", Sawon1.ACCOUNTING,2015,9,11),
				new Sawon1("C5001", "�����", Sawon1.HUMANRESOURCES,2017,2,11),
		};
		
		System.out.println("���� �����Դϴ�.");
		for(Sawon1 s : sawon) {
			System.out.println(s.infoString());
		}
		
		int idx;
		boolean b = false;
		
		System.out.println("~~~~~~~���� �� ����Դϴ�~~~~~~~");
		for(idx=0;idx<sawon.length;idx++) {
		if(new GregorianCalendar().getTime().getMonth()==sawon[idx].getEnterDate().getMonth() && 
				new GregorianCalendar().getTime().getDate()==sawon[idx].getEnterDate().getDate()) {
			System.out.println("���� "+sawon[idx].getName()+"  ���� �����Դϴ�. ���ϵ����");
			b=true;
			}//if
		}//for
		if(!b) {
			System.out.println("���� �����̽� ���� ���׿�.");
		}
		
		
		
		
		
		
	}//main
}
