package com.tj.op;
import java.util.*;
public class Example4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ֹε�Ϲ�ȣ ���� ���ڸ� ���ʴ�� �Է��ϼ���.");
		int[] num = new int[7];
		System.out.println("ù ��° ���ڸ� �Է��ϼ���");
		num[0]= scanner.nextInt();
		if(num[0]<1 || num[0]>9) {
			System.out.println("1~9������ �ڿ����� �Է��ϼ���");
			System.out.println("ù ��° ���ڸ� �Է��ϼ���");
			num[0]= scanner.nextInt();	
		}
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		num[1]= scanner.nextInt();
		if(num[1]<1 || num[1]>9) {
			System.out.println("1~9������ �ڿ����� �Է��ϼ���");
			System.out.println("�� ��° ���ڸ� �Է��ϼ���");
			num[1]= scanner.nextInt();	
		}
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		num[2]= scanner.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		num[3]= scanner.nextInt();
		System.out.println("�ټ� ��° ���ڸ� �Է��ϼ���");
		num[4]= scanner.nextInt();
		System.out.println("���� ��° ���ڸ� �Է��ϼ���");
		num[5]= scanner.nextInt();
		System.out.println("�ϰ� ��° ���ڸ� �Է��ϼ���");
		num[6]= scanner.nextInt();
		scanner.close();
		
		if(num[0]==1 || num[0]==3) {
			System.out.println("����� �����Դϴ�.");			
		}
		else if(num[0]==2 || num[0]==4) {
			System.out.println("����� �����Դϴ�.");
		}
		else {
			System.out.println("����!!!!");
		}
	}

}
