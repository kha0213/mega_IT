package com.tj.ex09;

public class ChildClass extends ParentClass {// i, method() ��ӹ���
	private int i = 20;
	public ChildClass() {
		System.out.println("ChildClass  ������");
	}
	@Override
	public void method() {
		
		System.out.println("ChildClass�� method");
		super.method();
		System.out.println("super���� i: "+super.i);
		System.out.println("Child�� i: "+i);
	}
	public int getI() {
		return i;
	}
}
