package com.tj.ex2_rect;

public class Rect_main {
	public static void main(String[] args) {
		System.out.println("Rect�� ������ ��ƺ���");
		
		Rect r1 = new Rect();
		Rect r2 = new Rect(10,5);
		Rect r3 = new Rect(6);
		
		r1.setHeight(10);
		r1.setWidth(99);
				
		System.out.println("r1�� �ʺ��"+r1.getHeight()+"�̰� ���̴�"+r1.getHeight()+"���̴�"+r1.area()+"�Դϴ�.");
		System.out.println("r2�� �ʺ��"+r2.getHeight()+"�̰� ���̴�"+r2.getHeight()+"���̴�"+r2.area()+"�Դϴ�");
		System.out.println("r3�� �ʺ��"+r3.getHeight()+"�̰� ���̴�"+r3.getHeight()+"���̴�"+r3.area()+"�Դϴ�");
		
		
		
		
	}

}
