package com.tj.ex3_math;

import java.util.Random;

public class Ex05_lotto {
	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		Random random = new Random();
		random.nextBytes(lotto); // byte 배열에 byte난수를 착착 넣음
		
		for(int i=0; i<lotto.length;i++) {
			int temp =Math.abs(lotto[i]); //0~127
			lotto[i]=(byte)(temp%45+1);
		}
		
		
		for(byte b : lotto) {
			System.out.print(" "+b);
		}
		
	}
}
