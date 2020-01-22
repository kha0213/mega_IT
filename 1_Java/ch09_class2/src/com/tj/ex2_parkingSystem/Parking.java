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
		System.out.println(carNum + "�� �������.");
		System.out.println("�����ð� " + inTime + "�� �Դϴ�.");
	}

	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURLYPARKINGRATE;
		System.out.println(carNum + "�� �ȳ��� ������.");
		System.out.println("�����ð� : " + inTime + "��");
		System.out.println("�����ð� : " + outTime + "��");
		System.out.println("������� : " + fee + "��");
	}

}
