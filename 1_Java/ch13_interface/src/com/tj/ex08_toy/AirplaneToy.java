package com.tj.ex08_toy;

public class AirplaneToy implements ILight, IMissile {
	public AirplaneToy() {
		System.out.println("������Դϴ�.");
		canLinght();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void canLinght() {
		System.out.println("�Һ� �ݻ� �� �� �ִ�.");
	}

}
