package com.tj.ex4_object;

public class Ex06_RectMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(5,6,"����");
		Rectangle r2 = (Rectangle)r1.clone();
		
		System.out.println(r1);
		System.out.println(r2);
		
		
		if(r1==r2) {
			System.out.println("������ �� �ƴ϶� ���� ��ü��");
		}else {
			System.out.println("������.");
		}
		if(r1.equals(r2)) {
			System.out.println("���� �׸�");
		}else {
			System.out.println("�ٸ� �׸�");
		}
		r1.setColor("���");
	}//main
}
