package com.tj.ex1_string;

public class Ex09_string {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		if(str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּҳ�");
		}
		str1 = "Python";
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҳ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҳ�");
		}
		str2 = "Python1";
		
	}
}
