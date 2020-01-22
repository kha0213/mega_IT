package com.tj.ex1_list;

import java.util.LinkedList;

public class Ex03_linkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("str0");
		linkedlist.add("str1");
		linkedlist.add("str2");
		linkedlist.add(0, "str00");
		linkedlist.set(1, "수정해떠염");
		linkedlist.remove(2);
		for(String s : linkedlist) {
			System.out.println(s);
		}
		for(int idx=0;idx<linkedlist.size();idx++) {
			System.out.println(linkedlist.get(idx));
		}
		
		linkedlist.clear();
		System.out.println(linkedlist.isEmpty()?"비워졌다":"안비워졌다");
	}
}
