package com.tj.ex1_string;

import java.util.Scanner;

public class Ex08_Friend_main {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-01"),
				new Friend("��浿", "010-8888-9999", "11-01"),
				new Friend("Ȳ����", "010-4594-7777", "10-24"),
		};
		Scanner sc = new Scanner(System.in);
		int idx;
		boolean searchOk = false;
		String searchTel;
		System.out.println("�˻��ϰ��� �ϴ� ģ���� ��ȭ��ȣ ���ڸ���?");
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
//			System.out.println("��ȭ��ȣ ��ã��.");
//		}
//		
		
		
		for(idx=0;idx<friends.length;idx++) {
			if(searchTel.equals(friends[idx].getTel().substring(friends[idx].getTel().lastIndexOf('-')+1))) {
				System.out.println("�� ģ���� ������"+friends[idx].infoString());
				searchOk = true;
				
			}
		}
		if(searchOk==false) {
			System.out.println("ģ�� ������ ã�� �� �����");
		}
		sc.close();
	}//main

}
