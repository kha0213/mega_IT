package com.tj.ex07_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� 0��¥�� ����");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("�Ű����� 1��¥�� ����");
	}
	
	//this. : �� ��ü�� 
    //this() : �� ��ü�� �������Լ�
	
	public Friend(String name,String tel) {
		this(name); 
		this.tel=tel;
		System.out.println("�Ű����� 2��¥�� ����");
	
	}
	public String infoString() {
		return name+" : "+tel;
	}

}
