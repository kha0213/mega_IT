package com.tj.ex4_object;

public class Rectangle implements Cloneable { // 빨간색 가로5, 세로6 네모
	
	private int width;
	private int height;
	private String color;
	public Rectangle() {
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	
	@Override
		public String toString() {
			return "가로:"+width+"\t 세로:"+height+"\t 색상:"+color;
		}
	
	@Override
		public boolean equals(Object obj) {
			if(obj!=null && obj instanceof Rectangle) {
				boolean widthChk = this.width==((Rectangle)obj).width;
				boolean heightChk = this.height==((Rectangle)obj).height;
				boolean colorChk = this.color.equals(((Rectangle)obj).color);
				return widthChk && heightChk && colorChk;
			}else {
				return false;
			}
		}
	
	@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
