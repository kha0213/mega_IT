package com.tj.ex1_store;

public class Store2 extends HeadQuarterStore {
	private String str = "���а� 2ȣ��";
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� ��¥");
	}
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 6,000��");
	}
	@Override
	public String getStr() {
		return str;
	}
}
