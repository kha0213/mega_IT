package com.tj.ex1_store;

public class Store1 extends HeadQuarterStore {
	private String str = "���ð� 1ȣ��";
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 ���Ⱦ�");
	}
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");		
	}
	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� ����");
	}
	
	@Override
	public String getStr() {
		return str;
	}
	

}
