package com.tj.ex12_final;

public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־�� ����ӵ� : "+speed);
	}
	public final void stop() {//stop() override ����
		speed = 0;
		System.out.println("�����!");
	}
	
}
