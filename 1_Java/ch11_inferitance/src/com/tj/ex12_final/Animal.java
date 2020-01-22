package com.tj.ex12_final;

public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("뛰고 있어요 현재속도 : "+speed);
	}
	public final void stop() {//stop() override 금지
		speed = 0;
		System.out.println("멈췄다!");
	}
	
}
