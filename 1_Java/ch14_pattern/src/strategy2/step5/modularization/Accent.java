package strategy2.step5.modularization;

import strategy2.step5.inter.EngineLow;
import strategy2.step5.inter.FuelDiesel;
import strategy2.step5.inter.Km20;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	
	@Override
	public void shape() {
		System.out.println("¿¢¼¾Æ® ");
		super.shape();
	}

}
