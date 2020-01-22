package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02_hashmap {
	public static void main(String[] args) {
		HashMap<String, String> hasp = new HashMap<String, String>();
		hasp.put("홍길동", "010-9999-9999");
		hasp.put("김길동", "010-8888-8888");
		hasp.put("박길동", "010-7777-7777");
		hasp.put("최길동", "010-6666-6666");
		
		System.out.println(hasp);
		Iterator<String> iterator = hasp.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+":"+hasp.get(key));
		}
		
	}
}
