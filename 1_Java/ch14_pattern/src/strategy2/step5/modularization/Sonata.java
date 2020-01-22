package strategy2.step5.modularization;

import strategy2.step5.inter.EngineMid;
import strategy2.step5.inter.FuelGasoline;
import strategy2.step5.inter.Km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.print("�ҳ�Ÿ ");
		super.shape();
	}

}
