package com.tj.ex5;

public class ThreadEx01Main {
	public static void main(String[] args) {
		Runnable r = new ThreadEx01();
		Thread th1 = new Thread(r);
		th1.start();
		for(int i=0;i<300;i++) {
			System.out.print('*');
		}
	}
}
