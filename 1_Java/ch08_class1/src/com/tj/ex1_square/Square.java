package com.tj.ex1_square;

public class Square {
	private int side;
		
	public Square() {System.out.println("매개변수가 없는 생성자 함수가 생성되었습니다.");//디폴트 생성자
	}// 생성자 함수
	public Square(int side) {
		this.side=side;
		System.out.println("매개변수가 int side인 생성자 함수가 생성되었습니다.");
	}
	public int area() {
		return side*side;		
	}
	
	
	public void setSide(int side) {
		System.out.println("side가"+side+"로 설정되었습니다.");
		this.side=side;		
	}
	public int getSide() {
		return side;		
	}

}


