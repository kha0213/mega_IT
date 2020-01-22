package com.tj.ex4_objectNThreadN;

public class ThreadEx02 extends Thread{
	private int num=0;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ A쓰레드 수행 중 ~ ~");
				num++;
			}
			System.out.println(Thread.currentThread().getName() + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//for
	}//run
	
	public int getNum() {
		return num;
	}

}
