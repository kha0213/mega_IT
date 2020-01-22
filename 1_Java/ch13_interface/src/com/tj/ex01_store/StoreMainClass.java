package com.tj.ex01_store;

// 추상클래스는 객체화 시킬 수 없다.
public class StoreMainClass {
	public static void main(String[] args) {
		
		Store1 s1 = new Store1();
		System.out.println(s1.getStr());
		s1.kimchi();
		s1.bude();
		s1.bibib();
		s1.sunde();
		s1.gonggibab();
		System.out.println("-----------------------");
		
		Store2 s2 = new Store2();
		System.out.println(s2.getStr());
		s2.kimchi();
		s2.bude();
		s2.bibib();
		s2.sunde();
		s2.gonggibab();
		System.out.println("-----------------------");

		Store3 s3 = new Store3();
		System.out.println(s3.getStr());
		s3.kimchi();
		s3.bude();
		s3.bibib();
		s3.sunde();
		s3.gonggibab();
		System.out.println("-----------------------");

		HeadQuarterStore[] storeArr = { new Store1(), new Store2(), new Store3(), };

		for (HeadQuarterStore store : storeArr) {
			if(store instanceof Store1) {
				System.out.println(((Store1) store).getStr());
			}
			else if(store instanceof Store2) {
				System.out.println(((Store2) store).getStr());
			}
			else if(store instanceof Store3) {
				System.out.println(((Store3) store).getStr());
			}
			store.kimchi();
			store.bude();
			store.bibib();
			store.sunde();
			store.gonggibab();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■");
		}

	}// main

}
