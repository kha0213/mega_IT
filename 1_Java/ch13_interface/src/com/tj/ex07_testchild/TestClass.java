package com.tj.ex07_testchild;

public class TestClass implements I1, I2, I3 {

	@Override
	public void m1() {
		System.out.println("��� i1 "+i1);
	}

	@Override
	public void m2() {
		System.out.println("��� i2 "+i2);
	}

	@Override
	public void m3() {
		System.out.println("��� i3 "+i3);
	}

}
