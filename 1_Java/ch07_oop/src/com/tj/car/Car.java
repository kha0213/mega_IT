package com.tj.car;

public class Car {
	private String color;
	private int cc; //��ⷮ
	private String brand;
	private int speed;
	public void drive() {
		speed = 60;
		System.out.println("�����Ѵ�. ���� �ӵ���"+speed);
	} // drive
	public void park() {
		speed = 0;
		System.out.println("�����Ѵ�. ���� �ӵ� "+speed);
	}
	public void race() {
		speed = 120;
		System.out.println("���̽��Ѵ�. ���� �ӵ� "+speed);
	}
	public void setColor(String c) {
		color = c; 
	}
	public String getColor() {
		return color; 
	}

}
