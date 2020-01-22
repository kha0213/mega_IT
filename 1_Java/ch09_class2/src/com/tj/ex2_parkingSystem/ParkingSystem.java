package com.tj.ex2_parkingSystem;

public class ParkingSystem {
	public static void main(String[] args) {
		Parking car1 = new Parking("11·ç1111", 12);
		Parking car2 = new Parking("22·ç2222", 12);
		car1.out(15);
		car2.out(16);
		Parking car3 = new Parking("333·ç3333", 9);
		car3.out(24);
	}

}