package com.tj.ex3_accesstest1;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember);
		//obj.privateMethod();
		System.out.println(obj.defaultMember);
		obj.defaultMethod();
		System.out.println(obj.protectedMember);
		obj.protectedMethod(); //���� ��Ű���ų� ��ӹ޾Ұų�
		System.out.println(obj.publicMember);
		obj.publicMember();
	}

}
