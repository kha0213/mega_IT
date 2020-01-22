package com.tj.ex6_vote;

public class VoteMain {
	public static void main(String[] args) {
		Runnable targetA = new VoteTarget();
		Runnable targetB = new VoteTarget();
		Runnable targetC = new VoteTarget();
		Thread threadA = new Thread(targetA, "A도시");
		Thread threadB = new Thread(targetB, "B도시");
		Thread threadC = new Thread(targetC, "C도시");
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
