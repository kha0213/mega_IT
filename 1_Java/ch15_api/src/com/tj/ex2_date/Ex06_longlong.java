package com.tj.ex2_date;

import java.util.Calendar;
import java.util.StringTokenizer;

import com.tj.ex1_string.Friend;

public class Ex06_longlong {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-11"), new Friend("김길동", "010-9999-8999", "12-11"),
				new Friend("박길동", "010-9999-7999", "11-17"), };
		// 1.오늘 생일인 얘 2.이번달 생일인 얘
		Calendar today = Calendar.getInstance();
		int month = today.get(Calendar.MONTH) + 1; // 1~12월
		int day = today.get(Calendar.DAY_OF_MONTH); // 1~31일

		int idx;
		for (idx = 0; idx < friends.length; idx++) {
			StringTokenizer[] token = new StringTokenizer[friends.length];
			token[idx] = new StringTokenizer(friends[idx].getBirth(), "-");
			if (Integer.parseInt(token[idx].nextToken()) == month && Integer.parseInt(token[idx].nextToken()) == day) {
				System.out.println(friends[idx].getName()+"님 생일이 같네요.");
			}

		} // for
		if(idx==friends.length) {
			System.out.println("생일 같은 사람이 없습니다.");
		}

	}
}
