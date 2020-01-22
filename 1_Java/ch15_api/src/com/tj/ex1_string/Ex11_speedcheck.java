package com.tj.ex1_string;


public class Ex11_speedcheck {
	public static void main(String[] args) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		String str = "A";
		
		for(int i=0;i<50000;i++) {
			str = str+"a";
			
		}
		endTime = System.currentTimeMillis();
		System.out.println("String 5���� �ɸ��ð�: "+(endTime-startTime));
		
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		
		for(int i=0;i<50000000;i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 5000���� ���� �ɸ��ð�: "+(endTime-startTime));
		
		
		StringBuilder strBui = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i=0;i<50000000;i++) {
			strBui.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 5000���� ���� �ɸ��ð�: "+(endTime-startTime));
		
		
		
	}
}
