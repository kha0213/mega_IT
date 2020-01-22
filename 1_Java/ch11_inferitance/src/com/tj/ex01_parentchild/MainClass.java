package com.tj.ex01_parentchild;

public class MainClass {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getMamiName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}

}
