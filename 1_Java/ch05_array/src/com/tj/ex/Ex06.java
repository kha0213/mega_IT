package com.tj.ex;
import java.util.*;
// int[] arr = {10,20,30,40,50} �迭 ���� ������ ���� ����ϴ� ���α׷�
public class Ex06 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+1+"��° ���ڸ� �Է��ϼ���.");
			arr[i] = sc.nextInt();
			}
		sc.close();
		int tot=0;
		for(int i=0;i<arr.length;i++) {
			tot+=arr[i];
		}
		System.out.println("�Է��� ������ ������ "+tot+"�Դϴ�.");
				
		
	}

}
