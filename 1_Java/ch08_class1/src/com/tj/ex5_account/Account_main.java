package com.tj.ex5_account;

import java.util.*;

public class Account_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String youAcc, youName;
		int youbalance;
		
		Account you = new Account();
		System.out.println("****계좌 생성 프로그램입니다.****");
						
		System.out.println("만약 스킵을 원하시면 -1을 입력해주세요.");
		
		System.out.println("계좌번호를 입력해주세요.");
				
		youAcc = sc.nextLine();		
		you.setAccountNumber(youAcc); 
		
		System.out.println("계좌 이름을 생성해주세요.");
		
		youName = sc.nextLine();
		you.setAccountName(youName);
		
		System.out.println("잔액을 입력해주세요.");
		
		youbalance = sc.nextInt();
		you.setBalance(youbalance);
		
		System.out.println("계좌 생성이 완료되었습니다.");
		
		System.out.printf("계좌번호 : %s  계좌이름 : %s  잔액 : %d원 입니다.\n", you.getAccountNumber(),you.getAccountName(),you.getBalance());
		sc.close();
	}

}
