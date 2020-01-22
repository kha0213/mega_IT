package com.tj.ex2_date;

import java.util.GregorianCalendar;

public class SawonMain {
	public static void main(String[] args) {
		Sawon1[] sawon = {new Sawon1("A2001", "롱롱이", Sawon1.COMPUTER,1990,12,11),
				new Sawon1("B1901", "영롱이", Sawon1.DESIGN),
				new Sawon1("A1001", "다롱이", Sawon1.ACCOUNTING,2015,9,11),
				new Sawon1("C5001", "헤롱이", Sawon1.HUMANRESOURCES,2017,2,11),
		};
		
		System.out.println("직원 정보입니다.");
		for(Sawon1 s : sawon) {
			System.out.println(s.infoString());
		}
		
		int idx;
		boolean b = false;
		
		System.out.println("~~~~~~~생일 자 명단입니다~~~~~~~");
		for(idx=0;idx<sawon.length;idx++) {
		if(new GregorianCalendar().getTime().getMonth()==sawon[idx].getEnterDate().getMonth() && 
				new GregorianCalendar().getTime().getDate()==sawon[idx].getEnterDate().getDate()) {
			System.out.println("오늘 "+sawon[idx].getName()+"  직원 생일입니다. 축하드려요");
			b=true;
			}//if
		}//for
		if(!b) {
			System.out.println("오늘 생일이신 분이 없네요.");
		}
		
		
		
		
		
		
	}//main
}
