package com.tj.ex2_rect;

public class Rect {
	
	private int width;
	private int height;
	public int area() {
		return width*height;
	}
	
	public Rect() {//����Ʈ ������
		System.out.println("�Ű������� ���� �������Լ��� �����Ǿ���~!~!");
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
