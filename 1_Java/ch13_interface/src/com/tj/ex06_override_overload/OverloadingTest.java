package com.tj.ex06_override_overload;

public class OverloadingTest {
	private int i1;
	private int i2;
	public OverloadingTest() {
		
	}
	public OverloadingTest(int i) {
		i1=i2=i;
	}
	public OverloadingTest(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	
	public void calculate() {
		System.out.println("i1+i2는 "+(i1+i2));
	}
	public void calculate(char op) {
		switch(op) {
		case '+' : 
			calculate();
			break;
		case '-' :
			System.out.println("i1-i2는 "+(i1-i2));
			break;
		case '*' :
			System.out.println("i1*i2는 "+(i1*i2));
			break;
		case '/' :
			System.out.println("i1/i2는 "+(i1/i2));
			break;
		case '%' :
			System.out.println("i1%i2는 "+(i1%i2));
			break;
		default:
			System.out.println("유효하지 않은 연산자입니다.");
			break;
		}
	}
	
	

}
