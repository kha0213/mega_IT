package com.tj.ex2_thread;

public class TargetEx02 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("¹Ý°©½À´Ï´Ù.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
}
