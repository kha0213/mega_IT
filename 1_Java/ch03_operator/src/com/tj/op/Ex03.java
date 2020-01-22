package com.tj.op;
// 비교연산자(관계연산자)
public class Ex03 {

	public static void main(String[] args) {
		int n1=33, n2=10;
		boolean result;
		result = (n1==n2); // n1과 n2가 같냐?
		System.out.printf("%d%s%d = %b\n", n1, "==", n2, result);
		result = (n1!=n2); // n1과 n2가 다르냐?
		System.out.printf("%d%s%d = %b\n", n1, "!=", n2, result);
		result = (n1>=n2); // n1이 n2보다 크거나 같냐?
		System.out.printf("%d%s%d = %b\n", n1, ">=", n2, result);
		result = (n1>n2); // n1과 n2가 크냐?
		System.out.printf("%d%c%d = %b\n", n1, '>', n2, result);
		

	}

}
