package com.tj.ex3_shape;

public class Circle extends Shape {
	private int r; //������
	public Circle(int r) {
		this.r=r;
	}
	@Override
	public double computerArea() {
		return r*r*3.14;
	}
	@Override
	public void draw() {
		System.out.print("�� ����� ");
		super.draw();
	}

}
