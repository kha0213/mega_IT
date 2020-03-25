package com.tj.ex2_vehicle;

public class Vehicle_imp implements Vehicle {
	private String vehicle; //탈 것
	private int speed;
	@Override
	public void ride(String name) {
		System.out.println(name+"은 "+vehicle+"을 타고 시속 "+speed+"km/h로 간다");
	}
	public Vehicle_imp(String vehicle, int speed) {
		super();
		this.vehicle = vehicle;
		this.speed = speed;
	}
	
}
