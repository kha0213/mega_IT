package com.tj.ex12_final;

public class Dog extends Animal {
	@Override
	public void running() {
		speed +=10; //setSpeed(get.Speed()+10)
		System.out.println("�ٸ鼭 ������ �����. ������. ����ӵ� : "+speed);
	}

}
