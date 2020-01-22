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
			System.out.println("TV 볼륨을 1만큼 올려 현재 볼륨 레벨이 "+volumeLevel+"이 되었어");
		}
		else {
			System.out.println("지금 볼륨레벨이 최대인 "+TV_MAX_VOLUME+"이어서 올리지 못했어.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level<=TV_MAX_VOLUME) {
			volumeLevel +=level;
			System.out.println("TV 볼륨을 "+level+"만큼 올려서 볼륨레벨이 "+volumeLevel+"이 되었어.");
		}
		else {
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel=TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대야.");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel>TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV 볼륨을 1만큼 내려 현재 볼륨 레벨이 "+volumeLevel+"이 되었어");
		}
		else {
			System.out.println("지금 볼륨레벨이 최소인 "+TV_MIN_VOLUME+"이어서 내리지 못했어.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level>=TV_MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("TV 볼륨을 "+level+"만큼 내려서 볼륨레벨이 "+volumeLevel+"이 되었어.");
		}
		else {
			int tempLevel = volumeLevel;
			volumeLevel=TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 내리고 "+tempLevel+"만큼 내려 최소야.");
		}
	}

}
