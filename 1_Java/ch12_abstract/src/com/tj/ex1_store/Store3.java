package com.tj.ex1_store;

public class Store3 extends HeadQuarterStore {
	private String str = "증권가 매장3호점";
	@Override
	public void kimchi() {
		System.out.println("김치찌개 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 7,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 6,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}
	public String getStr() {
		return str;
	}
}
