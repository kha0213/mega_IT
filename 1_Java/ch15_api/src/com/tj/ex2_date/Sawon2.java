package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	private String no;
	private String name;
	private PartType part;
	private Date enterDate;

	public Sawon2(String no, String name, PartType part) {
		this.no = no;
		this.name = name;
		this.enterDate = new Date();
		this.part = part;
	}

	public Sawon2(String no, String name, PartType part, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년M월d일");

	public String infoString() {
		return "[사번]" + no + "[이름]" + name + "[부서]" + part + "[입사일]" + sdf.format(enterDate);
	}



}
