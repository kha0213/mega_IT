package com.tj.ex08_super;

public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű����� ���� Baby������ ȣ���");
	}
	public Baby(String name,String character) {
		
//		setName(name);
//		setCharacter(character);
		super(name,character); // super() ; �� Ŭ������ ���۴��� ������ �Լ�
		System.out.println("�Ű����� 2��¥�� Baby");
	}
	@Override
	public void intro() {
		//super. : �� Ŭ������ ���۴���
		System.out.println("�ֱ�����");
		super.intro(); 
	}
}
