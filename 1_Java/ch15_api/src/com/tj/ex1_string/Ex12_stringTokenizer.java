package com.tj.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {
	public static void main(String[] args) {
		String str1 = "������ ���ػ� ������ ������ ������";
		String str2 = "2019/12/09";
		StringTokenizer tokenizer1 = new StringTokenizer(str1);
		StringTokenizer tokenizer2 = new StringTokenizer(str2,"/");
		
		System.out.println("tokenizer1�� ��ū����: "+tokenizer1.countTokens());
		System.out.println("tokenizer2�� ��ū����: "+tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.print(tokenizer1.nextToken());
			System.out.print(", ");
			System.out.println(tokenizer1.hasMoreTokens());
		}
		System.out.println();
		while(tokenizer2.hasMoreTokens()) {
			System.out.print(tokenizer2.nextToken());
			System.out.print(", ");
		}
		System.out.println();
		System.out.println(str1);
	}
}
