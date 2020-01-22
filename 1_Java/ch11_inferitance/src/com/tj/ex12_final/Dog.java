package com.tj.ex12_final;

public class Dog extends Animal {
	@Override
	public void running() {
		speed +=10; //setSpeed(get.Speed()+10)
		System.out.println("뛰면서 꼬리를 흔들어요. 강아지. 현재속도 : "+speed);
	}

}
