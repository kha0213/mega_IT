package com.tj.ex10speaker;

public class Speaker_main {
	public static void main(String[] args) {
		IVolume[] volumes = {new Speraker(3),new Tv(6)};
		
		for(IVolume vol : volumes) {
			vol.volumeDown();
			vol.volumeUp(10);
		}
		
		
		
	}

}
