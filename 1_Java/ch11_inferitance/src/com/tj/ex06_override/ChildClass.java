package com.tj.ex06_override;

public class ChildClass extends ParentClass { // method1(),method2()
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	@Override
	public void method2() {// override (�Լ��� ������)
		System.out.println("ChildClass�� method2()�Լ�");
	}
	public void method3() {
		System.out.println("ChildClass�� method3");
	}

}
