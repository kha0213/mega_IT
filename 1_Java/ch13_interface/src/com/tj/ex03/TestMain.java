package com.tj.ex03;

public class TestMain {

	public static void main(String[] args) {
		InterfaceClass ifc = new InterfaceClass();
		ifc.calculate();
		ifc.getStr();
		ifc.toString(); // Object에 있는것은 당연히 됨
		
		InterfaceEx1 if1 = new InterfaceClass();
		if1.calculate();
//		if1.getStr();  if1이 InterfaceEx1형 변수라서
		
		InterfaceEx2 if2 = new InterfaceClass();
//		if2.calculate();  if2이 InterfaceEx2형 변수라서 안됨
		if2.getStr();
		System.out.println("InterfaceEx1의 상수 : "+InterfaceEx1.CONSTANT_NUM);
		System.out.println("InterfaceEx2의 상수 : "+InterfaceEx2.CONSTANT_STRING);
		System.out.println("InterfaceClass의 상수 : "+InterfaceClass.CONSTANT_NUM);
		System.out.println("InterfaceClass의 상수 : "+InterfaceClass.CONSTANT_STRING);

	}

}
