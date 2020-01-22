package com.tj.ex3_shape;

public class Rectangle extends Shape {
	private int w;
	private int h;
	

	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}


	@Override
	public double computerArea() {
		return w*h;
	}
	
	@Override
	public void draw() {
		System.out.print("사각형 모양의 ");
		super.draw();
	}

}
