package com.tj.ex3_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();

		Student h1 = new Student("�շ�", 1);
		Student h2 = new Student("�շ�", 1); // �շ�:1
		System.out.println(Objects.deepEquals(h1, h2));
		
		System.out.println(h1.equals(h2));
		System.out.println("~~~~~~~~~~~~~~");
		hashset.add(new Student("�շ���", 1));
		hashset.add(new Student("�շ���", 2));
		hashset.add(new Student("�շ���", 3));
		hashset.add(new Student("a����", 1));
		System.out.println(hashset.size());

		System.out.println(hashset);

		Iterator<Student> iterator = hashset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
