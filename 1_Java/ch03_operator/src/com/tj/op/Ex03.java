package com.tj.op;
// �񱳿�����(���迬����)
public class Ex03 {

	public static void main(String[] args) {
		int n1=33, n2=10;
		boolean result;
		result = (n1==n2); // n1�� n2�� ����?
		System.out.printf("%d%s%d = %b\n", n1, "==", n2, result);
		result = (n1!=n2); // n1�� n2�� �ٸ���?
		System.out.printf("%d%s%d = %b\n", n1, "!=", n2, result);
		result = (n1>=n2); // n1�� n2���� ũ�ų� ����?
		System.out.printf("%d%s%d = %b\n", n1, ">=", n2, result);
		result = (n1>n2); // n1�� n2�� ũ��?
		System.out.printf("%d%c%d = %b\n", n1, '>', n2, result);
		

	}

}
