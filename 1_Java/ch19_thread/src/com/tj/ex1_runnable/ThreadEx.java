package com.tj.ex1_runnable;

public class ThreadEx implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("ThreadEx");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"�� i = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
