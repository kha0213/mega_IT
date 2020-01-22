package com.tj.ex2_rect;

public class Rect {
	
	private int width;
	private int height;
	public int area() {
		return width*height;
	}
	
	public Rect() {//디폴트 생성자
		System.out.println("매개변수가 없는 생성자함수가 생성되었당~!~!");
	}
	public Rect(int width,int height) {
		this.width=width;
		this.height=height;		
	}
	
	
	public Rect(int s) {
		width= height=s;
	}
		
	public void setWidth(int w) {
		width=w;
	}
	public int getWidth() {
		return width;		
	}
	public void setHeight(int h) {
		height=h;
	}
	public int getHeight() {
		return height;		
	}

}
