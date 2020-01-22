package com.tj.ex4_objectNThreadN;
//ThreadEx02 extends Thread

public class ThreadEx02TestMain {
	public static void main(String[] args) {
		ThreadEx02 threadA = new ThreadEx02();
		threadA.setName("A");
		ThreadEx02 threadB = new ThreadEx02();
		threadB.setName("B");
	
//		threadA.run(); 이건 동시에 실행이 안됨
//		threadB.run();
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main함수 종료 전 : A의 num = "+threadA.getNum());
		System.out.println("main함수 종료 전 : B의 num = "+threadB.getNum());
		
		System.out.println("main 함수");
	}
}
