package com.tj.ex1_square;

public class Square {
	private int side;
		
	public Square() {System.out.println("�Ű������� ���� ������ �Լ��� �����Ǿ����ϴ�.");//����Ʈ ������
	}// ������ �Լ�
	public Square(int side) {
		this.side=side;
		System.out.println("�Ű������� int side�� ������ �Լ��� �����Ǿ����ϴ�.");
	}
	public int area() {
		return side*side;		
	}
	
	
	public void setSide(int side) {
		System.out.println("side��"+side+"�� �����Ǿ����ϴ�.");
		this.side=side;		
	}
	public int getSide() {
		return side;		
	}

}


