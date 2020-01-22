package com.tj.homework;

public class Employee_main {
	public static void main(String[] args) {
		Employee[] sawon= {new SalaryEmployee("영롱이", 65000000),
				new SalaryEmployee("나리", 59000000),
				new SalaryEmployee("이학배", 20000000),
				new HourlyEmployee("정석원", 220, 9000),
				new HourlyEmployee("최서원", 240, 8500)
		};
		
		
		for(Employee temp : sawon) {
			temp.computePay();
			temp.computeIncentive();
			System.out.println("----월 급 명 세 서----");
			System.out.println(temp.toString());
			System.out.println("수 고 하 셨 습 니 다 .");
		}
	}
}