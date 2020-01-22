package com.tj.ex06_override;

public class MainClass {
	public static void main(String[] args) {
		ParentClass parentObj = new ParentClass(5);
		parentObj.method1();
		parentObj.method2();
		System.out.println("¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾ ¢¾");
		ChildClass childObj = new ChildClass(3);
		childObj.method1();
		childObj.method2();
		childObj.method3();
		if(childObj.equals(parentObj)) {
			System.out.println("°°¾Æ¿ä");
		}
	}

}
