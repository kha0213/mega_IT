package com.tj.ex2_rect;

public class Rect_main {
	public static void main(String[] args) {
		System.out.println("Rect를 가지고 놀아보자");
		
		Rect r1 = new Rect();
		Rect r2 = new Rect(10,5);
		Rect r3 = new Rect(6);
		
		r1.setHeight(10);
		r1.setWidth(99);
				
		System.out.println("r1의 너비는"+r1.getHeight()+"이고 높이는"+r1.getHeight()+"넓이는"+r1.area()+"입니다.");
		System.out.println("r2의 너비는"+r2.getHeight()+"이고 높이는"+r2.getHeight()+"넓이는"+r2.area()+"입니다");
		System.out.println("r3의 너비는"+r3.getHeight()+"이고 높이는"+r3.getHeight()+"넓이는"+r3.area()+"입니다");
		
		
		
		
	}

}
