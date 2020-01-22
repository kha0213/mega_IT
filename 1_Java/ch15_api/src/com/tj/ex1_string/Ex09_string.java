package com.tj.ex1_string;

public class Ex09_string {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		if(str1 == str2) {
			System.out.println("str1과 str2는 같은 주소네");
		}
		str1 = "Python";
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소네");
		}else {
			System.out.println("str1과 str2는 다른 주소네");
		}
		str2 = "Python1";
		
	}
}
