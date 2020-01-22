package com.tj.ex2_date;

import java.util.Calendar;

import com.tj.ex1_string.Friend;

public class Ex06 {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-11"), new Friend("김길동", "010-9999-8999", "2-11"),
				new Friend("박길동", "010-9999-7999", "11-17"), };
		// 1.오늘 생일인 얘 2.이번달 생일인 얘
		Calendar today = Calendar.getInstance();
		
		
		
		int month = today.get(Calendar.MONTH) + 1; // 1~12월
		int day = today.get(Calendar.DAY_OF_MONTH); // 1~31일
		
		String monthStr = (month<10)? ("0"+month):""+month;
		String dayStr = (day<10)? ("0"+day) : ""+day;
		String todayStr = monthStr+"-"+dayStr;
		System.out.println("오늘은 "+todayStr);
		
		boolean searchOk = false;
		
		for(Friend f : friends) {
			if(f.getBirth().equals(todayStr)) {
				System.out.println("~~~축하해요 오늘 생일이에요~~~");
				System.out.println(f.infoString());
				searchOk = true;
			}//if
		}//for
		if(!searchOk) {
			System.out.println("생일이 아무도 없어요!");
		}//if

	}
}
