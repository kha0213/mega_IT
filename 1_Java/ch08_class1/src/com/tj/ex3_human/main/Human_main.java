package com.tj.ex3_human.main;

import com.tj.ex3_human.Man; // ctrl+shift+o �� ���ʿ��� import ����
import com.tj.ex3_human.Woman;

public class Human_main {
	public static void main(String[] args) {
		Man man = new Man();
		Man man2 = new Man(10);
		Woman woman = new Woman();
		
		System.out.println(man);
		System.out.println(man2);
		System.out.println(woman);
	}

}
