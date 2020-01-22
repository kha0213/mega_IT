package com.tj.ex3_accesstest1;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember);
		//obj.privateMethod();
		System.out.println(obj.defaultMember);
		obj.defaultMethod();
		System.out.println(obj.protectedMember);
		obj.protectedMethod(); //같은 패키지거나 상속받았거나
		System.out.println(obj.publicMember);
		obj.publicMember();
	}

}
