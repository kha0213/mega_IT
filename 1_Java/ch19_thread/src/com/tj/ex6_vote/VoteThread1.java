package com.tj.ex6_vote;

import java.util.Random;

public class VoteThread1 extends Thread{
	private int count; // 개표율
	private Random random;
	private final int TARGETCNT = 100; // 목표 카운트
	private StringBuilder graph;
	private int num;
	
	
	
	public VoteThread1(String name) {
		super(name);
		count = 0;
		random = new Random();
		graph = new StringBuilder();
		num = 0;
	}



	public VoteThread1() {
		count = 0;
		random = new Random();
		graph = new StringBuilder();
		num = 0;
	}



	@Override
	public void run() {
		while (count != TARGETCNT) {
			num = random.nextInt(10);
			count += num;
			if (count >= TARGETCNT) {
				count = TARGETCNT;
				System.out.println(Thread.currentThread().getName()+"끝");
			}
			
			graph.delete(0, graph.toString().length());
			
			for (int i = 0; i < count/10; i++) {
				graph.append('★');
			}
			System.out.println(Thread.currentThread().getName() + "\t" + count + "%개표\t" + graph);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
