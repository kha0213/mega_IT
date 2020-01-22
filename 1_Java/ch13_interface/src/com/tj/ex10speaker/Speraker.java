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
			System.out.println("스피커 볼륨이" + SPEAKER_MAX_VOLUMELEVEL + "으로 최대입니다.");
		} else {
			System.out.println("스피커 볼륨 1만큼 올려 현재 레벨이 " + volumeLevel + "입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if (volumeLevel >= SPEAKER_MAX_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MAX_VOLUMELEVEL;
			System.out.println("스피커 볼륨이" + SPEAKER_MAX_VOLUMELEVEL + "으로 최대입니다.");
		} else {
			volumeLevel += level;
			System.out.println("스피커 볼륨 " + level + "만큼 올려 현재 레벨이 " + volumeLevel + "입니다.");
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if (volumeLevel <= SPEAKER_MIN_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MIN_VOLUMELEVEL;
			System.out.println("스피커 볼륨이" + SPEAKER_MIN_VOLUMELEVEL + "으로 최소입니다.");
		} else {
			System.out.println("스피커 볼륨 1만큼 내려 현재 레벨이 " + volumeLevel + "입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= SPEAKER_MIN_VOLUMELEVEL) {
			volumeLevel = SPEAKER_MIN_VOLUMELEVEL;
			System.out.println("스피커 볼륨이" + SPEAKER_MIN_VOLUMELEVEL + "으로 최소입니다.");
		} else {
			System.out.println("스피커 볼륨 " + level + "만큼 내려 현재 레벨이 " + volumeLevel + "입니다.");
		}
	}

}
