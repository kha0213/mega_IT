package com.tj.ex1_store;

public class Store2 extends HeadQuarterStore {
	private String str = "´ëÇÐ°¡ 2È£Á¡";
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä 5,000¿ø");
	}
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä ²ÇÂ¥");
	}
	
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 6,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ 6,000¿ø");
	}
	@Override
	public String getStr() {
		return str;
	}
}
