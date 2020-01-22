package com.tj.ex4_man;

public class Man_main {
	public static void main(String[] args) {
		Man kim = new Man();
		kim.setWeight(80);
		kim.setHeight(185);

		Man lee = new Man(190,72);
	//	kim = lee;
	//	lee.setHeight(100);
		
		System.out.printf("%.2f , %.2f", kim.calculateBMI(), lee.calculateBMI());
		
		
		double biman = kim.calculateBMI();
		if(biman > 24) {
			System.out.println("kim 비만");
		}
		else {
			System.out.println("님 건강");
		}
		
		biman = lee.calculateBMI();
		if(biman > 24) {
			System.out.println("lee 비만");
		}
		else {
			System.out.println(lee.getClass().getName()+"님 건강");
		}
		
		
		
		
//		System.out.println("lee의 BMI"+lee.calculateBMI());
//		System.out.println("kim의 BMI"+kim.calculateBMI());
//		
//		System.out.println(kim.getHeight()+","+kim.getPhoneNum());
//		System.out.println(lee.getHeight()+","+lee.getPhoneNum());
			
		
	}//main

}//class