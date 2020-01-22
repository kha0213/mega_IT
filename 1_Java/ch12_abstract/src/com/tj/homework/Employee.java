package com.tj.homework;

public abstract class Employee {
	private String name;
	private int computePay;
	private int computeIncentive;
	
	public abstract int computePay();
	
	public final int computeIncentive() {
		if(computePay>=2000000) {
			computeIncentive=(int)(computePay*0.1);
			return computeIncentive;
		}
		else {
			return 0;
		}
		
	}
		
	@Override
	public String toString() {
		if(computeIncentive!=0) {
			return "��  �� : " + name + "\n��  �� : " + computePay + "��\n��  �� : " + computeIncentive + "��";
		}
		else {
			return "��  �� : " + name + "\n��  �� : " + computePay + "��";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getComputePay() {
		return computePay;
	}

	public void setComputePay(int computePay) {
		this.computePay = computePay;
	}

	public int getIncentive() {
		return computeIncentive;
	}

	public void setIncentive(int computeIncentive) {
		this.computeIncentive = computeIncentive;
	}

	public int getComputeIncentive() {
		return computeIncentive;
	}

	public void setComputeIncentive(int computeIncentive) {
		this.computeIncentive = computeIncentive;
	}
	
	
	

}
