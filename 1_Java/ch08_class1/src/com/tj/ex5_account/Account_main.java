package com.tj.ex5_account;

import java.util.*;

public class Account_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String youAcc, youName;
		int youbalance;
		
		Account you = new Account();
		System.out.println("****���� ���� ���α׷��Դϴ�.****");
						
		System.out.println("���� ��ŵ�� ���Ͻø� -1�� �Է����ּ���.");
		
		System.out.println("���¹�ȣ�� �Է����ּ���.");
				
		youAcc = sc.nextLine();		
		you.setAccountNumber(youAcc); 
		
		System.out.println("���� �̸��� �������ּ���.");
		
		youName = sc.nextLine();
		you.setAccountName(youName);
		
		System.out.println("�ܾ��� �Է����ּ���.");
		
		youbalance = sc.nextInt();
		you.setBalance(youbalance);
		
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		
		System.out.printf("���¹�ȣ : %s  �����̸� : %s  �ܾ� : %d�� �Դϴ�.\n", you.getAccountNumber(),you.getAccountName(),you.getBalance());
		sc.close();
	}

}
