package com.tj.ex1_store;

public class Store1 extends HeadQuarterStore {
	private String str = "ÁÖÅÃ°¡ 1È£Á¡";
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ ¾ÈÆÈ¾Æ");
	}
	
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 5,000¿ø");		
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä 5,000¿ø");
	}
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä ¹«·á");
	}
	
	@Override
	public String getStr() {
		return str;
	}
	

}
