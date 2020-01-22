package strategy2.step5.modularization;

import strategy2.step5.inter.IEngine;
import strategy2.step5.inter.IFuel;
import strategy2.step5.inter.IKm;

public class Car {
	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	

	public void drive() {
		System.out.println("����̺� �� �� �ִ�.");
	}
	public void shape() {
		System.out.println("�� ����� door, sheet, handle�� �̷�����ִ�.");
	}
		
	public void isEngine() {
		engine.engine();
	}
	public void isKmPerLitter() {
		km.kmPerLetter();
	}
	public void isFuel() {
		fuel.fuel();
	}

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void setKm(IKm km) {
		this.km = km;
	}

	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
	
}
