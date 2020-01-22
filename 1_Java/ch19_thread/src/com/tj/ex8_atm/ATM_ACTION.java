package com.tj.ex8_atm;

public class ATM_ACTION implements Runnable{
	private boolean flag; //boolean true면 찾고 false면 저금
	private ATM obj;
	public ATM_ACTION(ATM obj) {
		flag= false;
		this.obj=obj;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			if(flag) {
				obj.deposit((int)(Math.random()*10000), Thread.currentThread().getName());
				flag = false;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				obj.withdraw((int)(Math.random()*10000), Thread.currentThread().getName());
				flag = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
