package com.tj.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 4900;
		if (seoulLunchPrice > 7000) {
			System.out.println("���� �䰪 ��γ׿�");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("���ɰ� ���ݸ� ����������");
		} else if (seoulLunchPrice >= 4000) {
			System.out.println("���ɰ� ���׿�");
		} else {
			System.out.println("����� ���ϰڳ�");
		}

	}

}
