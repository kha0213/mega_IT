package com.tj.ex3_shape;

public class Triangle extends Shape {
	private int w;
	private int h;

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public void draw() {
		System.out.print("삼각형 모양의 ");
		super.draw();
	}

	@Override
	public double computerArea() {
		return w*h/2;
	}

}
