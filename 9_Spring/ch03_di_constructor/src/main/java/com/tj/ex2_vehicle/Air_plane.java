package com.tj.ex2_vehicle;

public class Air_plane implements Vehicle {

	@Override
	public void ride(String name) {
		System.out.println(name+"은 비행기를 타고 시속 1000km/h로 간다");
		
	}

}
