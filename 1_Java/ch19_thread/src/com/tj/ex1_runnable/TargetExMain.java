package com.tj.ex1_runnable;

public class TargetExMain {
	public static void main(String[] args) {
		TargetEx01 target1 = new TargetEx01();
		TargetEx02 target2 = new TargetEx02();
		Thread threadA = new Thread(target1, "A"); //target1�� run()�۾��� �ϴ� A������ ����!!
		Thread threadB = new Thread(target2, "A"); //target2�� run()�۾��� �ϴ� A������ ����!!
		threadA.start();
		threadB.start();
		for(int i =0;i<10;i++) {
			System.out.println("���� main ������");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
