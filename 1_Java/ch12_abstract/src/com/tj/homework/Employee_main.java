package com.tj.homework;

public class Employee_main {
	public static void main(String[] args) {
		Employee[] sawon= {new SalaryEmployee("������", 65000000),
				new SalaryEmployee("����", 59000000),
				new SalaryEmployee("���й�", 20000000),
				new HourlyEmployee("������", 220, 9000),
				new HourlyEmployee("�ּ���", 240, 8500)
		};
		
		
		for(Employee temp : sawon) {
			temp.computePay();
			temp.computeIncentive();
			System.out.println("----�� �� �� �� ��----");
			System.out.println(temp.toString());
			System.out.println("�� �� �� �� �� �� �� .");
		}
	}
}