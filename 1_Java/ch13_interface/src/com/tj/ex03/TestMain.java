package com.tj.ex03;

public class TestMain {

	public static void main(String[] args) {
		InterfaceClass ifc = new InterfaceClass();
		ifc.calculate();
		ifc.getStr();
		ifc.toString(); // Object�� �ִ°��� �翬�� ��
		
		InterfaceEx1 if1 = new InterfaceClass();
		if1.calculate();
//		if1.getStr();  if1�� InterfaceEx1�� ������
		
		InterfaceEx2 if2 = new InterfaceClass();
//		if2.calculate();  if2�� InterfaceEx2�� ������ �ȵ�
		if2.getStr();
		System.out.println("InterfaceEx1�� ��� : "+InterfaceEx1.CONSTANT_NUM);
		System.out.println("InterfaceEx2�� ��� : "+InterfaceEx2.CONSTANT_STRING);
		System.out.println("InterfaceClass�� ��� : "+InterfaceClass.CONSTANT_NUM);
		System.out.println("InterfaceClass�� ��� : "+InterfaceClass.CONSTANT_STRING);

	}

}
