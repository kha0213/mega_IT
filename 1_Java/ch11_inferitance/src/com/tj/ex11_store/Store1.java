package com.tj.ex11_store;

public class Store1 extends HeadQuarterStore {
	private String str = "주택가 1호점";
	@Override
	public void budai() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 안팔아");
	}
	@Override
	public String getStr() {
		return str;
	}
	

}
