package com.tj.ch18.dto;

import java.sql.Date;

public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;
	private String binfo;
	private int startRow;
	private int endRow;

	public Book() {
		super();
	}

	
	


	public Book(int bnum, String btitle, String bwriter, Date brdate, String bimg1, String bimg2, String binfo,
			int startRow, int endRow) {
		super();
		this.bnum = bnum;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.brdate = brdate;
		this.bimg1 = bimg1;
		this.bimg2 = bimg2;
		this.binfo = binfo;
		this.startRow = startRow;
		this.endRow = endRow;
	}





	public String getBwriter() {
		return bwriter;
	}





	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}





	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	
	public Date getBrdate() {
		return brdate;
	}

	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}

	public String getBimg1() {
		return bimg1;
	}

	public void setBimg1(String bimg1) {
		this.bimg1 = bimg1;
	}

	public String getBimg2() {
		return bimg2;
	}

	public void setBimg2(String bimg2) {
		this.bimg2 = bimg2;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	@Override
	public String toString() {
		return "Book [bnum=" + bnum + ", btitle=" + btitle + ", brdate=" + brdate + ", bimg1=" + bimg1 + ", bimg2="
				+ bimg2 + ", binfo=" + binfo + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	
}
