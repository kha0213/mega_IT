package com.tj.ex2_thread;
// Thread threadA = new ThreadEx();
// threadA.setName("A");
// ThreadEx threadA = new ThreadEx("A");
public class ThreadEx extends Thread {
	public ThreadEx() {
		this("");
	}
	public ThreadEx(String name) {
		super(name); // ������ �̸��� ��� == setName
		
	}//������
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("ThreadEx");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"�� i�� = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
