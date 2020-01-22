package com.tj.ex1_runnable;

public class ThreadExTestMain {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인함수 끝");
	}
}
