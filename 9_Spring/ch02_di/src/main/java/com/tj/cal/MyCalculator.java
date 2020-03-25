package com.tj.cal;

public class MyCalculator {
	private int n1;
	private int n2;
	private Calculator calculator;
	public void add() {
		calculator.addition(n1, n2);
	}
	public void sub() {
		calculator.subtraction(n1, n2);
	}
	public void mul() {
		calculator.multiplication(n1, n2);
	}
	public void div() {
		calculator.division(n1, n2);
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
}
