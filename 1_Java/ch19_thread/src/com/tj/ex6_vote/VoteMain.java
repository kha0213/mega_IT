package com.tj.ex6_vote;

public class VoteMain {
	public static void main(String[] args) {
		Runnable targetA = new VoteTarget();
		Runnable targetB = new VoteTarget();
		Runnable targetC = new VoteTarget();
		Thread threadA = new Thread(targetA, "A����");
		Thread threadB = new Thread(targetB, "B����");
		Thread threadC = new Thread(targetC, "C����");
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
