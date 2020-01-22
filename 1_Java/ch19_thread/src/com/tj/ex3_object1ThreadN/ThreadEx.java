package com.tj.ex3_object1ThreadN;

// Thread N���� ��ü 1�� ����
public class ThreadEx implements Runnable {
	private int num = 0; // ��������

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ A������ ���� �� ~ ~");
				num++;
			}
			System.out.println(Thread.currentThread().getName() + "�� num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//for
	}

}
