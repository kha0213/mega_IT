package com.tj.ex14_defaultmethod;

public class Tv implements RemoteControl {
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�");
	}

	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�");
	}

	@Override
	public void setVolume(int volume) {
		if(volume<MIN_VOLUME) {
			this.volume=MIN_VOLUME;
		}
		else if(volume>MAX_VOLUME) {
			this.volume=MAX_VOLUME;
		}
		else {
			this.volume=volume;
		}
		System.out.println("���� TV ������ "+this.volume+"�Դϴ�.");
	}

}
