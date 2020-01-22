package com.tj.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_hashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		hashSet.add("str2");
		hashSet.add("라라");
		hashSet.add("블라");
		System.out.println("size="+hashSet.size());
		System.out.println(hashSet);
		
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
