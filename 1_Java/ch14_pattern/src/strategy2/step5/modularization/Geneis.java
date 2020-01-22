package strategy2.step5.modularization;

import strategy2.step5.inter.EngineHigh;
import strategy2.step5.inter.FuelGasoline;
import strategy2.step5.inter.Km10;

public class Geneis extends Car {

	public Geneis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.print("제네시스 ");
		super.shape();
	}
}
