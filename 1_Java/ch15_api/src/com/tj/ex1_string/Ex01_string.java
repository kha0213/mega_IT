package com.tj.ex1_string;

public class Ex01_string {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҴ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҴ�");
		}
		if(str1==str3) {
			System.out.println("str1�� str3�� ���� �ּҴ�");
		}else {
			System.out.println("str1�� str3�� �ٸ� �ּҴ�");
		}
		if(str3==str4) {
			System.out.println("str3�� str4�� ���� �ּҴ�");
		}else {
			System.out.println("str3�� str4�� �ٸ� �ּҴ�");
		}
		
		System.out.println("str1�� str2�� ���� ��Ʈ���̳�?"+((str1.equals(str2))?"�� �¾�":"�ƴ� Ʋ��"));
		
		System.out.println("str1�� �ؽ��ڵ�"+str1.hashCode());
		System.out.println("str2�� �ؽ��ڵ�"+str2.hashCode());
		System.out.println("str3�� �ؽ��ڵ�"+str3.hashCode());
		System.out.println("str4�� �ؽ��ڵ�"+str4.hashCode());
		
		boolean b = str1==str3;
		System.out.println(b);
	}

}
