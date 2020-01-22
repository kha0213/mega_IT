package com.tj.loop;

public class Ex05_for {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			if(i==3)
				//break; 브레이크는 for문 끝으로
				continue; //컨티뉴는 바로 for로 다시 돌아간다
			System.out.println(i);
		}
	}

}
