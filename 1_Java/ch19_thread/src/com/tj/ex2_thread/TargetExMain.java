package com.tj.ex2_thread;

public class TargetExMain {
	public static void main(String[] args) {
		Thread threadA = new TargetEx01();//������ ������ ���ÿ� run(); �� �̹� ���ǵ�
		threadA.setName("A"); //�׳� �����ذ� ���ص� ��
		Thread threadB = new TargetEx02();//������ ������ ���ÿ� run(); �� �̹� ���ǵ�
		threadB.setName("B");
		threadA.start();
		threadB.start();
		
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"������");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
