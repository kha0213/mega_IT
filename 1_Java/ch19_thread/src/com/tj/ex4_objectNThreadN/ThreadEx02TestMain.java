package com.tj.ex4_objectNThreadN;
//ThreadEx02 extends Thread

public class ThreadEx02TestMain {
	public static void main(String[] args) {
		ThreadEx02 threadA = new ThreadEx02();
		threadA.setName("A");
		ThreadEx02 threadB = new ThreadEx02();
		threadB.setName("B");
	
//		threadA.run(); �̰� ���ÿ� ������ �ȵ�
//		threadB.run();
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main�Լ� ���� �� : A�� num = "+threadA.getNum());
		System.out.println("main�Լ� ���� �� : B�� num = "+threadB.getNum());
		
		System.out.println("main �Լ�");
	}
}
