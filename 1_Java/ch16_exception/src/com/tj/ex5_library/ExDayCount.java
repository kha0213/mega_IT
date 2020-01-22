package com.tj.ex5_library;

import java.text.SimpleDateFormat;
import java.util.*;

public class ExDayCount {
	public static void main(String[] args) {
		//Date checkOutDate = new Date(119, 10, 13); //2019,11,13으로 셋팅
		Date checkOutDate = new Date(new GregorianCalendar(2019,10,13).getTimeInMillis()); //2019,11,13으로 셋팅
		Date now = new Date();
		long checkOutMillis = checkOutDate.getTime(); // 1970.1.1~2019.11.13까지 밀리세컨
		long nowMillis = now.getTime(); // 1970.1.1~2019.12.13까지 밀리세컨
		long diff = nowMillis - checkOutMillis; //빌린동안의 밀리세컨
		long day = diff/(24*60*60*1000);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(checkOutDate));
		System.out.println(sdf.format(now));
		System.out.println(day);
		
		if(day>14) {
			System.out.println((day-14)*100+"원 연체료를 내셔야 반납처리 가능합니다.");
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료를 받으셨나요?Y/N (N:반납중단)");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.exit(0); // checkIn method에서는 return으로 대체
			}
		}
		
		System.out.println("반납처리진행");
		
	}
}

