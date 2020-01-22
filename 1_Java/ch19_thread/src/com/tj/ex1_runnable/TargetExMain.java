package com.tj.ex1_runnable;

public class TargetExMain {
	public static void main(String[] args) {
		TargetEx01 target1 = new TargetEx01();
		TargetEx02 target2 = new TargetEx02();
		Thread threadA = new Thread(target1, "A"); //target1의 run()작업을 하는 A쓰레드 생성!!
		Thread threadB = new Thread(target2, "A"); //target2의 run()작업을 하는 A쓰레드 생성!!
		threadA.start();
		threadB.start();
		for(int i =0;i<10;i++) {
			System.out.println("나는 main 쓰레드");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
