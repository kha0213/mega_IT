package com.tj.op;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("***���������***");
		int n1=33, n2=10;
		int result; 
		double resultDouble;
		
		result = n1+n2;
		System.out.printf("%d%c%d=%d\n",n1,'+',n2,result);
		result = n1-n2;
		System.out.printf("%d%c%d=%d\n",n1,'-',n2,result);
		result = n1*n2;
		System.out.printf("%d%c%d=%d\n",n1,'*',n2,result);
		result = n1/n2;
		resultDouble = (double)n1 / n2;
		System.out.printf("%d%c%d=%.2f\n",n1,'/',n2,resultDouble);
		
		result = n1%n2;
		System.out.printf("%d %c %d= %d\n",n1,'%',n2,result);
		// ������ �������� �뵵 : ¦Ȧ�� �Ǻ�, x��� �Ǻ�
		if(n1%2 == 0) {
			System.out.println("n1�� ¦���Դϴ�.");}
		else {
			System.out.println("n1�� Ȧ���Դϴ�.");}
		
		if(n2%5 == 0) {
			System.out.println("n2�� 5�� ����Դϴ�.");
		}
		else {
			System.out.println("n2�� 5�� ��� �ƴմϴ�.");
		}

	}

}
