package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_simpleDateFormat {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm��");
		String todayStr = sdf.format(date);
		System.out.println(todayStr);
	}

}
