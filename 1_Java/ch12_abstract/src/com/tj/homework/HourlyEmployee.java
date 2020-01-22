package com.tj.homework;

public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;

	public HourlyEmployee(String name,int hoursWorked,int moneyPerHour) {
		super();
		setName(name);
		this.hoursWorked=hoursWorked;
		this.moneyPerHour=moneyPerHour;
	}

	@Override
	public int computePay() {
		setComputePay(hoursWorked*moneyPerHour);
		return getComputePay();
	}

}
