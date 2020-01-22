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
				new SimpleDateFormat("yyyy-MM-dd E요일 a hh:mm:ss:SS"),
				new SimpleDateFormat("오늘은 올해의 D번째 날입니다."),
				new SimpleDateFormat("오늘은 이달의 W번째 주입니다."),
				new SimpleDateFormat("오늘은 올해의 w번째 주입니다.")};
		
		for(SimpleDateFormat s : sdf) {
			System.out.println(s.format(date));
		}//for
	}
//※ Date 클래스
//	날짜를 표현하는 클래스
//	날짜 정보를 객체간에 주고 받을 때 주로 사용
}