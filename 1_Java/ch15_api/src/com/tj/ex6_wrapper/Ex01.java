package com.tj.ex6_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i1 =10;
		int i2 =10;
		if(i1==i2) {
			System.out.println("�� int�� ����");
		}
		Integer obj1 = new Integer(10);
		Integer obj2 = new Integer(10);
		if(obj2!=obj1) {
			System.out.println("obj1�� obj2�� �ٸ���.");
		}
		int total = obj1.intValue()+obj2.intValue();
		System.out.println("obj1�� obj2�� ���� "+total);
		
		
	}
}
