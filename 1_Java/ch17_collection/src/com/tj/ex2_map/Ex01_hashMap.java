package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_hashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(0, "str0"); //hashmap.put(new Integer(0), "str0");
		hashmap.put(100, "str1");
		hashmap.put(2, "str2");
		hashmap.put(3, "str3");
		
		
		System.out.println("remove 전 : "+hashmap);
		hashmap.remove(2); // 특정한  것만 삭제
		System.out.println("remove 후 : "+hashmap);
		hashmap.put(2, "또");
		System.out.println("remove 후 : "+hashmap);
		hashmap.clear();
		System.out.println(hashmap.isEmpty()?"비었어":"안비어쓰");
		hashmap.put(0, "Hong gildong");
		hashmap.put(1, "Kim dongil");
		hashmap.put(2, "Lee soonsin");
		hashmap.put(3, "Yu ain");
		
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+": "+hashmap.get(key));
		}
		
		
	}
}
