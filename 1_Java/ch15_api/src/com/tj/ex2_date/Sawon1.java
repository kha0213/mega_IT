package com.tj.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon1 {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	private String no;
	private String name;
	private String part;
	private Date enterDate;

	public Sawon1(String no, String name, String part) {
		this.no = no;
		this.name = name;
		this.enterDate = new Date();
		this.part = part;
	}

	public Sawon1(String no, String name, String part, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.part = part;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년M월d일");

	public String infoString() {
		return "[사번]" + no + "[이름]" + name + "[부서]" + part + "[입사일]" + sdf.format(enterDate);
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

}
