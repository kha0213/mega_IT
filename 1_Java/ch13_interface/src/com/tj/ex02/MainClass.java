package com.tj.ex02;

public class MainClass {

	public static void main(String[] args) {
		S s1 = new C(); //1.��ü(����)�� Ÿ�� ������
		
		s1.method();
		
		C c1 = new C();
		
		c1.method();
		
		S s2 = new S();
		
		s1.method(); // C�� method() . �������̵�
		
		s2.method(); // S�� method()
		
		s2.method();
		System.out.println("�����ε� ������ ����");
		s2.method();
		s2.method(10);
		s1.method();
		s1.method(10);
		

	}

}
