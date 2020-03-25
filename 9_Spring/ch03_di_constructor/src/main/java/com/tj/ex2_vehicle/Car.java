package com.tj.ex2_vehicle;

public class Car implements Vehicle {

	@Override
	public void ride(String name) {
		System.out.println(name+"은 차로 70km/h로 간다.");
	}

}
