package com.tj.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 4900;
		if (seoulLunchPrice > 7000) {
			System.out.println("점심 밥값 비싸네요");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("점심값 조금만 저렴했으면");
		} else if (seoulLunchPrice >= 4000) {
			System.out.println("점심값 좋네요");
		} else {
			System.out.println("사장님 망하겠네");
		}

	}

}
