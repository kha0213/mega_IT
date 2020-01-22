package strategy2.step5.modularization;

import strategy2.step5.inter.FuelHybrid;
import strategy2.step5.inter.Km20;

public class CarMain {
	public static void main(String[] args) {
		Car[] cars = {new Geneis(), new Accent(), new Sonata()};
		
		System.out.println("// 수정전입니다.");
		for(Car c : cars) {
			System.out.println("~~~~~~~~~~~~");
			c.shape();
			c.drive();
			c.isEngine();
			c.isFuel();
			c.isKmPerLitter();
		}
		
		cars[2].setFuel(new FuelHybrid());
		cars[2].setKm(new Km20());
		
		for(Car c : cars) {
			System.out.println("~~~~~~~~~~~~");
			c.shape();
			c.drive();
			c.isEngine();
			c.isFuel();
			c.isKmPerLitter();
		}
		
		
	}

}
