package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02_hashmap {
	public static void main(String[] args) {
		HashMap<String, String> hasp = new HashMap<String, String>();
		hasp.put("ȫ�浿", "010-9999-9999");
		hasp.put("��浿", "010-8888-8888");
		hasp.put("�ڱ浿", "010-7777-7777");
		hasp.put("�ֱ浿", "010-6666-6666");
		
		System.out.println(hasp);
		Iterator<String> iterator = hasp.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+":"+hasp.get(key));
		}
		
	}
}
