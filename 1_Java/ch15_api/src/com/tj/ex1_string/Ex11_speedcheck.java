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
		System.out.println("String 5만번 걸린시간: "+(endTime-startTime));
		
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		
		for(int i=0;i<50000000;i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 5000만번 수정 걸린시간: "+(endTime-startTime));
		
		
		StringBuilder strBui = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i=0;i<50000000;i++) {
			strBui.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 5000만번 수정 걸린시간: "+(endTime-startTime));
		
		
		
	}
}
