package com.tj.ex1_list;

import java.util.*;

public class Ex05_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new AClass());
		vec.add(new BClass());
		vec.add("string");
		vec.add(0);
		System.out.println(vec.toString());
		System.out.println(vec.get(3));
		System.out.println(vec.elementAt(2));
		
		vec.clear();
		if(vec.isEmpty()) {
			System.out.println("비워졌네");
		}
	}
}
