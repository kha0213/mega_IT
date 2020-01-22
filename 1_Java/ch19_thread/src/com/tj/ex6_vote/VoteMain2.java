package com.tj.ex6_vote;

public class VoteMain2 {
	public static void main(String[] args) {
		VoteThread1 location1 = new VoteThread1();
		location1.setName("A도시");
		VoteThread1 location2 = new VoteThread1();
		location2.setName("B도시");
		VoteThread1 location3 = new VoteThread1();
		location3.setName("C도시");
		
		location1.start();
		location2.start();
		location3.start();
	}
}
