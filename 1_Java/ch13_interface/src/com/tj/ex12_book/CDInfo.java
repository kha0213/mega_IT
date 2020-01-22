package com.tj.ex12_book;

public class CDInfo {
	private String cdNo;
	private String cdTitle;
	
	public CDInfo(String cdNo, String cdTitle) {
		super();
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
	}
	public String getCdNo() {
		return cdNo;
	}
	public void setCdNo(String cdNo) {
		this.cdNo = cdNo;
	}
	public String getCdTitle() {
		return cdTitle;
	}
	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

}
