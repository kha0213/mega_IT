package com.tj.ex5_pouch;

public class Child {
	//MomPouch momPouch=new MomPouch();
	private String name;
	public Child(String name) {
		this.name=name;
	}
	public void takeMoney(int money) {
		if(MomPouch.money>=money) {
			MomPouch.money-=money;
			System.out.println(name+"�� "+money+"�� �޾ư��� ���������� "+MomPouch.money+"�� ����");
		}else {
			System.out.println(name+"�� �� ������. ���� ������ ���� ���ڶ�");
		}
	}
}
