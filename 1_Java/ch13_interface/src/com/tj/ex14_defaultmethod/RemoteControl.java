package com.tj.ex14_defaultmethod;

public interface RemoteControl {
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	public default void mute(boolean mute) {
		if(mute) {
			System.out.println("���� ó��");
		}else {
			System.out.println("���� ����");
		}
		
	}
	public static void changeBattery() {
		System.out.println("������ ��ȯ�մϴ�.");
	}
}
