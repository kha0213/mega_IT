package com.tj.ex4_object;

public class Ex07_getClassGetSuperClass {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10,5,"°ËÁ¤»ö");
		
		Class cls = obj.getClass();
		String name=cls.getName();
		System.out.println(cls.getName());
		System.out.println(name.substring(name.lastIndexOf(".")+1));
		System.out.println(cls.getSimpleName());
		System.out.println(cls.getTypeName());
		
		Class superCls = obj.getClass().getSuperclass();
		System.out.println(superCls.getName());
		System.out.println(superCls.getSimpleName());
	}
}
