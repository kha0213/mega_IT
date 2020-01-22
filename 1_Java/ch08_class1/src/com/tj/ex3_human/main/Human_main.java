package com.tj.ex3_human.main;

import com.tj.ex3_human.Man; // ctrl+shift+o 는 불필요한 import 생략
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
