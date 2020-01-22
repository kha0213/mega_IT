package com.tj.ex3_accesstest1;

public class AccessTest {
//	private int privateMember;
	int defaultMember;
	protected int protectedMember;
	public int publicMember;
	public AccessTest() {
//		privateMember = 10;
		defaultMember = 20;
		protectedMember = 30;
		publicMember = 40;
	}
//	private void privateMethod() {
//		System.out.println("private Method");
//	}
	void defaultMethod() {
		System.out.println("default Method");
	}
	protected void protectedMethod() {
		System.out.println("protected Method");
	}
	public void publicMember() {
		System.out.println("public Method");
	}

}
