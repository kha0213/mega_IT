package com.tj.ex3_math;

import java.util.Random;

public class Ex04_lotto {
	public static void main(String[] args) {
		Random random = new Random();
		byte [] lotto = new byte[6];
		
		byte temp;
		for(int i=0;i<lotto.length;i++) {
			lotto[i]=(byte)(random.nextInt(45)+1);
			for(int j=0;j<i;j++) {
				if(lotto[j]==lotto[i]) {
					i--;
				}else if(lotto[j]>lotto[i]) {
					temp = lotto[j];
					lotto[j]=lotto[i];
					lotto[i]=temp;
				}
			}
		}//for
		
		System.out.print("로또 숫자 6개는 [");
		for(int i=0;i<lotto.length;i++) {
			if(i<lotto.length-1) {
				System.out.print(lotto[i]+", ");
			}else {
				System.out.println(lotto[i]+"]");
			}
		}
		
		
		
		
	}
}
