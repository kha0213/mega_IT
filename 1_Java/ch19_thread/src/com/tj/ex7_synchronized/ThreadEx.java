package com.tj.ex7_synchronized;

// Thread N개에 객체 1개 공유
public class ThreadEx implements Runnable {
	private int num = 0; // 공유변수

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // for
	}

	private synchronized void out() {
		if (Thread.currentThread().getName().equals("A")) {
			System.out.println("~ ~ A쓰레드 수행 중 ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName() + "의 num = " + num);

	}
}
