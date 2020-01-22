package com.tj.ex10speaker;

public class Speraker implements IVolume {
	private final int SPEAKER_MAX_VOLUMELEVEL = 20;
	private final int SPEAKER_MIN_VOLUMELEVEL = 0;
	private int volumeLevel;
	
	public Speraker(int volumeLevel) {
		if (volumeLevel>=SPEAKER_MAX_VOLUMELEVEL) {
			this.volumeLevel=SPEAKER_MAX_VOLUMELEVEL;
		}
		else if (volumeLevel<=SPEAKER_MIN_VOLUMELEVEL) {
			this.volumeLevel=SPEAKER_MIN_VOLUMELEVEL;
		}
		else {
			this.volumeLevel=volumeLevel;
		}
	}

	@Override
	public void volumeUp() {
		volumeLevel++;
		if (volumeLevel >= SPEAKER_MAX_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MAX_VOLUMELEVEL;
			System.out.println("����Ŀ ������" + SPEAKER_MAX_VOLUMELEVEL + "���� �ִ��Դϴ�.");
		} else {
			System.out.println("����Ŀ ���� 1��ŭ �÷� ���� ������ " + volumeLevel + "�Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if (volumeLevel >= SPEAKER_MAX_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MAX_VOLUMELEVEL;
			System.out.println("����Ŀ ������" + SPEAKER_MAX_VOLUMELEVEL + "���� �ִ��Դϴ�.");
		} else {
			volumeLevel += level;
			System.out.println("����Ŀ ���� " + level + "��ŭ �÷� ���� ������ " + volumeLevel + "�Դϴ�.");
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if (volumeLevel <= SPEAKER_MIN_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MIN_VOLUMELEVEL;
			System.out.println("����Ŀ ������" + SPEAKER_MIN_VOLUMELEVEL + "���� �ּ��Դϴ�.");
		} else {
			System.out.println("����Ŀ ���� 1��ŭ ���� ���� ������ " + volumeLevel + "�Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= SPEAKER_MIN_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MIN_VOLUMELEVEL;
			System.out.println("����Ŀ ������" + SPEAKER_MIN_VOLUMELEVEL + "���� �ּ��Դϴ�.");
		} else {
			System.out.println("����Ŀ ���� " + level + "��ŭ ���� ���� ������ " + volumeLevel + "�Դϴ�.");
		}
	}

}
