package com.tj.ex1_runnable;
//�ݰ����ϴ� 10���ϴ� Ÿ�� ����
public class TargetEx02 implements Runnable {
	@Override
	public void run() {
		for (int i=0;i<10;i++){
			System.out.println("�ݰ����ϴ�.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
