package com.tj.ex1_runnable;
//�ȳ��ϼ��� 10�� �ϴ� Ÿ�� ����
public class TargetEx01 implements Runnable {
	

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println("�ȳ��ϼ���");
			try {//���� �۾��� 500�и�����(0.5��)���� �����·� �ϴ� ��
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
