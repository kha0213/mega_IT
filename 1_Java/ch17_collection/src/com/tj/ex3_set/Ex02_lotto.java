package com.tj.ex3_set;

import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		Random random = new Random();
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		while(lotto.size()<6) {
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
		
	}
}
