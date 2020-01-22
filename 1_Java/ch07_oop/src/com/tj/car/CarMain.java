package com.tj.car;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("»¡°­");
//		myPorsche.brand = "Porsche";
//		myPorsche.cc = 3000;
		System.out.println(myPorsche.getColor());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		Car hisPorsche = yourPorsche;
		System.out.println(myPorsche.getColor());
	}

}
