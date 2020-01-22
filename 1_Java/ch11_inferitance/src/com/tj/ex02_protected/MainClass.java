package com.tj.ex02_protected;

public class MainClass {
	public static void main(String[] args) {
		Child s = new Child();
		s.setIJ(10,20);
		System.out.println("i´Â "+s.getI());
		System.out.println("j´Â "+s.getJ());
		s.sum();
	}

}
