package com.tj.ex11_store;

public class Store1 extends HeadQuarterStore {
	private String str = "���ð� 1ȣ��";
	@Override
	public void budai() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 ���Ⱦ�");
	}
	@Override
	public String getStr() {
		return str;
	}
	

}
