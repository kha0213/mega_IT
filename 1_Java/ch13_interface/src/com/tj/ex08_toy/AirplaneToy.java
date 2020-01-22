package com.tj.ex08_toy;

public class AirplaneToy implements ILight, IMissile {
	public AirplaneToy() {
		System.out.println("비행기입니다.");
		canLinght();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	@Override
	public void canLinght() {
		System.out.println("불빛 반사 할 수 있다.");
	}

}
