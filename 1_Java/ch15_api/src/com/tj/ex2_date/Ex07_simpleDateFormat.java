package com.tj.ex2_date;

import java.text.*;
import java.util.*;

public class Ex07_simpleDateFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		// y년 M월 
		// d일 
		// D 월구분없는일(1~365) 
		// E 요일 
		// a오전/오후 
		// W월의 몇번째 주 
		// w 년의 몇번째주
		// H시(0~23)
		// h시(1~12)
		// m 분 
		// s초
		// S밀리세컨드(1/1000)
		
		String todayStr = sdf.format(cal.getTime());  // cal.getTime() = cal을 date형으로 바꾼 것
		System.out.println(todayStr);
		
		
		
	}

}
