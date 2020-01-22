package com.tj.ex1_list;

import java.util.*;

public class Ex04_link_vs_array {
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		
		System.out.println("arraylist ������ �߰� �ð� "+addSequenceTime(arraylist));
		System.out.println("linkedlist ������ �߰� �ð� "+addSequenceTime(linkedList));
		
		System.out.println("arraylist ������ ���� �ð� "+removeSequenceTime(arraylist));
		System.out.println("linkedlist ������ ���� �ð� "+removeSequenceTime(linkedList));

		System.out.println("arraylist ���� �߰� �ð� "+addRandomTime(arraylist));
		System.out.println("linkedlist ���� �߰� �ð� "+addRandomTime(linkedList));
		
		System.out.println("arraylist ���� ���� �ð� "+removeRandomTime(arraylist));
		System.out.println("linkedlist ���� ���� �ð� "+removeRandomTime(linkedList));
		
	}
	
	private static long removeSequenceTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1; i>1000; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	
	private static long addSequenceTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<5000000; i++) {
			list.add("���������� �߰�");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long addRandomTime(List<String> list){
		long start = System.currentTimeMillis();
		for(int i=0; i<1000; i++) {
			list.add(10,"�������� �߰�");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long removeRandomTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<1000; i++) {
			list.remove(10);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	
}
