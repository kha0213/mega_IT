package com.tj.ex2_parkingSystem;

import com.tj.cons.PiClass;

public class Parking {
	private int inTime;
	private String carNum;
	private int outTime;
	private int fee;
//	private static final int HOURLYPARKINGRATE = 2000;

	public Parking() {

	}

	public Parking(String carNum, int inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		System.out.println(carNum + "님 어서오세요.");
		System.out.println("입차시간 " + inTime + "시 입니다.");
	}

	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURLYPARKINGRATE;
		System.out.println(carNum + "님 안녕히 가세요.");
		System.out.println("입차시간 : " + inTime + "시");
		System.out.println("출차시간 : " + outTime + "시");
		System.out.println("주차요금 : " + fee + "원");
	}

}
