package com.tj.ex04_acor;
// DMB 송수신가능, LTE, TV리모콘 미탑재
public class CModel implements IAcor {
	private String model = "C모델";

	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB송수신가능");
	}

	@Override
	public void lte() {
		System.out.println(model+"은 LTE모델");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"은 TV리모콘 미탑재");
	}

}
