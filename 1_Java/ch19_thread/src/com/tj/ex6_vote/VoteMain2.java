package com.tj.ex6_vote;

public class VoteMain2 {
	public static void main(String[] args) {
		VoteThread1 location1 = new VoteThread1();
		location1.setName("A����");
		VoteThread1 location2 = new VoteThread1();
		location2.setName("B����");
		VoteThread1 location3 = new VoteThread1();
		location3.setName("C����");
		
		location1.start();
		location2.start();
		location3.start();
	}
}
