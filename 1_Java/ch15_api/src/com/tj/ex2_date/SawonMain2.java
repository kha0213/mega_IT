package com.tj.ex2_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon1[] sawon = {new Sawon1("A2001", "�շ���", Sawon1.COMPUTER,1990,12,11),
				new Sawon1("B1901", "������", Sawon1.DESIGN),
				new Sawon1("A1001", "�ٷ���", Sawon1.ACCOUNTING,2015,9,11),
				new Sawon1("C5001", "�����", Sawon1.HUMANRESOURCES,2017,2,11),
		};
		
		System.out.println("���� �����Դϴ�.");
		for(Sawon1 s : sawon) {
			System.out.println(s.infoString());
		}
		
		Sawon2 s4 = new Sawon2("c100-02","��浿",PartType.COMPUTER);
		System.out.println(s4.infoString());
		
		
		
	}//main
}
