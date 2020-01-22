package com.tj.ex14_defaultmethod;

public class Tv implements RemoteControl {
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
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
		System.out.println("현재 TV 볼륨은 "+this.volume+"입니다.");
	}

}
