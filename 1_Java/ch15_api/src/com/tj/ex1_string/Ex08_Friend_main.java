package com.tj.ex1_string;

import java.util.Scanner;

public class Ex08_Friend_main {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-01"),
				new Friend("김길동", "010-8888-9999", "11-01"),
				new Friend("황정훈", "010-4594-7777", "10-24"),
		};
		Scanner sc = new Scanner(System.in);
		int idx;
		boolean searchOk = false;
		String searchTel;
		System.out.println("검색하고자 하는 친구의 전화번호 뒷자리는?");
		searchTel = sc.next();
		
//		for(Friend friend : friends) {
//			String tel = friend.getTel();
//			String postTel = tel.substring(tel.lastIndexOf('-')+1);
//			if(postTel.equals(searchTel)) {
//				System.out.println(friend.infoString());
//				searchOk = true;
//			}
//		}
//		if(searchOk==false) {
//			System.out.println("전화번호 못찾아.");
//		}
//		
		
		
		for(idx=0;idx<friends.length;idx++) {
			if(searchTel.equals(friends[idx].getTel().substring(friends[idx].getTel().lastIndexOf('-')+1))) {
				System.out.println("그 친구의 정보는"+friends[idx].infoString());
				searchOk = true;
				
			}
		}
		if(searchOk==false) {
			System.out.println("친구 정보를 찾을 수 없어요");
		}
		sc.close();
	}//main

}
