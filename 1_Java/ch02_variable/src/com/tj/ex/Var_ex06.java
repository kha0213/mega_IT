package com.tj.ex;

public class Var_ex06 {
	public static void main(String[] args) {
		float f1 = 10.0000017f, f2 = 100.1f;
		System.out.printf("f1=%7.1f\n", f1);  // 5�ڸ�Ȯ�� �Ҽ��� 1�ڸ� �ݿø��ؼ� 
		System.out.printf("f2=%7.2f\n", f2);
		f1 = 10.000001f;
		double d = 10.000001;
		System.out.printf("f1=%f\n",f1);
		System.out.printf("d=%f\n", d);
		System.out.println("f1="+f1);
		System.out.println("d="+d);
		
		if(f1==d)
			System.out.println("f1�� d�� ����");
		else
			System.out.println("f1�� d�� �ٸ���");
	
		
		
	}

}
