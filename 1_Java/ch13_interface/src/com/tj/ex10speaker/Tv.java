package com.tj.ex10speaker;

public class Tv implements IVolume {
	private final int TV_MAX_VOLUME = 30;
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public Tv(int volumeLevel) {
		if (volumeLevel>=TV_MAX_VOLUME) {
			this.volumeLevel=TV_MAX_VOLUME;
		}
		else if (volumeLevel<=TV_MIN_VOLUME) {
			this.volumeLevel=TV_MIN_VOLUME;
		}
		else {
			this.volumeLevel=volumeLevel;
		}
	}
	
	@Override
	public void volumeUp() {
		if(volumeLevel<TV_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("TV ������ 1��ŭ �÷� ���� ���� ������ "+volumeLevel+"�� �Ǿ���");
		}
		else {
			System.out.println("���� ���������� �ִ��� "+TV_MAX_VOLUME+"�̾ �ø��� ���߾�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<=TV_MAX_VOLUME) {
			volumeLevel +=level;
			System.out.println("TV ������ "+level+"��ŭ �÷��� ���������� "+volumeLevel+"�� �Ǿ���.");
		}
		else {
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel=TV_MAX_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ��.");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel>TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV ������ 1��ŭ ���� ���� ���� ������ "+volumeLevel+"�� �Ǿ���");
		}
		else {
			System.out.println("���� ���������� �ּ��� "+TV_MIN_VOLUME+"�̾ ������ ���߾�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level>=TV_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("TV ������ "+level+"��ŭ ������ ���������� "+volumeLevel+"�� �Ǿ���.");
		}
		else {
			int tempLevel = volumeLevel;
			volumeLevel=TV_MIN_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� ������ "+tempLevel+"��ŭ ���� �ּҾ�.");
		}
	}

}
