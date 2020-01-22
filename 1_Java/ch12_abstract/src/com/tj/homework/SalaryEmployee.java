package com.tj.homework;

public class SalaryEmployee extends Employee {
	private int annualSalary;

	public SalaryEmployee(String name,int annualSalary) {
		super();
		setName(name);
		this.annualSalary=annualSalary;
	}

	@Override
	public int computePay() {
		setComputePay((int)(annualSalary/14));
		return getComputePay();

	}

}
