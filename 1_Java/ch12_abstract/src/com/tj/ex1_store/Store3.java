package com.tj.ex1_store;

public class Store3 extends HeadQuarterStore {
	private String str = "���ǰ� ����3ȣ��";
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 7,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 6,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}
	public String getStr() {
		return str;
	}
}
