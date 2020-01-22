package com.tj.ex5_car;

public class HighGradeCar extends Car {
	private int tax = 500000;

	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}

	@Override
	public void getSpec() {
		if(getDisplacement()>=2000) {
			tax += 1000000;
		}
		System.out.println(" ��   �� : "+getColor());
		System.out.println(" Ÿ�̾� : "+getTire());
		System.out.println(" ��ⷮ : "+getDisplacement());
		System.out.println(" ��   �� : "+getHandle());
		System.out.println(" ��   �� : "+tax);
	}

}
